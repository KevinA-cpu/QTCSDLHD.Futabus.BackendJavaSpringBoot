package com.heisenburg.backend.service.implementation;


import com.heisenburg.backend.exceptions.DefaultException;
import com.heisenburg.backend.entity.Job;
import com.heisenburg.backend.repository.JobRepository;
import com.heisenburg.backend.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobServiceImplementation implements JobService {
    private final JobRepository jobRepository;

        public Page<Job> getJobs(Pageable pageable){
            try {
                return jobRepository.findAll(pageable);
            } catch (Exception ex){
                log.error(ex.getMessage());
                throw new DefaultException(ex.getMessage());
            }
        }

        public Optional<Job> getJob(String id){
            try {
                return jobRepository.findById(id);
            } catch (Exception ex){
                log.error(ex.getMessage());
                throw new DefaultException(ex.getMessage());
            }
        }
}
