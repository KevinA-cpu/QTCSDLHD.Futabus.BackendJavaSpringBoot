package com.heisenburg.backend.repository;

import com.heisenburg.backend.entity.Application;
import com.heisenburg.backend.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends MongoRepository<Application, String> {
    @Query("{ 'job' : ?0, 'details.idNumber' : ?1, 'details.phoneNumber' : ?2  }")
    Optional<Job> existsByJobAndDetails_IdNumberAndDetails_PhoneNumber(String job, String idNumber, String phoneNumber);

    @Query("{ 'code' : ?0, 'details.phoneNumber' : ?1 }")
    Optional<Application> findByCodeAndPhoneNumber(String code, String phoneNumber);

    @Query("{ 'details.phoneNumber' : ?0, 'details.idNumber' : ?1 }")
    List<Application> findByPhoneNumberAndID(String phoneNumber, String id);
}
