package com.heisenburg.backend.service;

import com.heisenburg.backend.dto.ApplicationDTO;
import com.heisenburg.backend.dto.DetailsDTO;
import com.heisenburg.backend.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Application createApplication(ApplicationDTO applicationDTO);
    Application updateApplication(String id, DetailsDTO detailsDTO);
    Optional<Application> getApplicationByCodeAndPhoneNumber(String code, String phoneNumber);
    List<Application> getApplicationsByPhoneNumberAndID(String phoneNumber, String id);
}
