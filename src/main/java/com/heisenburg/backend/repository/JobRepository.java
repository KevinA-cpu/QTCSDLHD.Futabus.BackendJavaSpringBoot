package com.heisenburg.backend.repository;

import com.heisenburg.backend.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {
}
