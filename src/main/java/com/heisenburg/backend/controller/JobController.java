package com.heisenburg.backend.controller;

import com.heisenburg.backend.entity.Job;
import com.heisenburg.backend.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@RequiredArgsConstructor
@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "http://localhost:5173")
public class JobController {
    private final JobService jobService;

    @GetMapping("")
    public ResponseEntity<Page<Job>> getJobs(
            @RequestParam(defaultValue = "0",required = false) Integer pageNo,
            @RequestParam(defaultValue = "10",required = false) Integer pageSize,
            @RequestParam(defaultValue = "id",required = false) String sortBy)
    {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return ResponseEntity.ok(jobService.getJobs(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Job>> getJob(@PathVariable String id)
    {
        Optional<Job> job = jobService.getJob(id);
        return ResponseEntity.ok().body(job);
    }
}
