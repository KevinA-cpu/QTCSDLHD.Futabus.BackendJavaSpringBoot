package com.heisenburg.backend.controller;

import com.heisenburg.backend.dto.ApplicationDTO;
import com.heisenburg.backend.dto.DetailsDTO;
import com.heisenburg.backend.entity.Application;
import com.heisenburg.backend.service.ApplicationService;
import com.heisenburg.backend.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")
@CrossOrigin(origins = "http://localhost:5173")
public class AppicationController {
    private final ApplicationService applicationService;

    @PostMapping("")
    public Application createApplication(@Valid @RequestBody ApplicationDTO applicationDTO) {
        return applicationService.createApplication(applicationDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<Application>> fetchApplicationsWithPhoneNumberAndIdCard(
            @RequestParam String phoneNumber,
            @RequestParam String idCard) {
        List<Application> applications = applicationService.getApplicationsByPhoneNumberAndID(phoneNumber, idCard);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/single")
    public ResponseEntity<Optional<Application>> getApplication(@RequestParam String code,
                                                            @RequestParam String phoneNumber) {
        Optional<Application> application = applicationService.getApplicationByCodeAndPhoneNumber(code, phoneNumber);
        return ResponseEntity.ok(application);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable String id, @RequestBody DetailsDTO detailsDTO) {
            Application updatedApplication = applicationService.updateApplication(id, detailsDTO);
            return ResponseEntity.ok(updatedApplication);
    }
}
