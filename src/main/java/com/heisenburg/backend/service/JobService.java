package com.heisenburg.backend.service;


import com.heisenburg.backend.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface JobService {
    Page<Job> getJobs(Pageable pageable);

    Optional<Job> getJob(String id);
}
