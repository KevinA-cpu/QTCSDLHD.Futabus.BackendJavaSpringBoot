package com.heisenburg.backend.service.implementation;

import com.heisenburg.backend.dto.DetailsDTO;
import com.heisenburg.backend.mapper.ApplicationMapper;
import com.heisenburg.backend.exceptions.DefaultException;
import com.heisenburg.backend.dto.ApplicationDTO;
import com.heisenburg.backend.entity.Application;
import com.heisenburg.backend.mapper.DetailsMapper;
import com.heisenburg.backend.repository.ApplicationRepository;
import com.heisenburg.backend.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImplementation implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper = ApplicationMapper.INSTANCE ;
    private final DetailsMapper detailsMapper = DetailsMapper.INSTANCE;

    private String generateRandomCode() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(6)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    public Application createApplication(ApplicationDTO applicationDTO) {
        if (applicationRepository.existsByJobAndDetails_IdNumberAndDetails_PhoneNumber(
                applicationDTO.getJob(),
                applicationDTO.getDetails().getIdNumber(),
                applicationDTO.getDetails().getPhoneNumber()).isPresent()) {
            throw new DefaultException("An application with the provided details already exists.");
        }
        try {
            Application application = new Application();
            application.setJob(applicationDTO.getJob());
            application.setDetails(detailsMapper.toDetails(applicationDTO.getDetails()));
            application.setStatus("Đang xem xét");
            application.setCode(generateRandomCode());
            application.setJobName(applicationDTO.getJobName());
            return applicationRepository.save(application);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public Application updateApplication(String id, DetailsDTO detailsDTO) {
        Optional<Application> existingApplication = applicationRepository.findById(id);
        if (existingApplication.isEmpty()) {
            throw new DefaultException("Application not found.");
        }
        try {
            Application application = existingApplication.get();
            application.setDetails(detailsMapper.toDetails(detailsDTO));
            return applicationRepository.save(application);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public Optional<Application> getApplicationByCodeAndPhoneNumber(String code, String phoneNumber) {
        // Use your repository to fetch the application based on code and phone number.
        try{
            return applicationRepository.findByCodeAndPhoneNumber(code, phoneNumber);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public List<Application> getApplicationsByPhoneNumberAndID(String phoneNumber, String id) {
        try{
            return applicationRepository.findByPhoneNumberAndID(phoneNumber, id);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            throw new DefaultException(ex.getMessage());
        }
    }
}

