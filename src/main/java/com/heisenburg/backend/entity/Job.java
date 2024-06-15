package com.heisenburg.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "jobs")
public class Job {
    public Job(String id, String name, String companyName, String location, String salary, Date submissionDeadline, JobDetails details) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.location = location;
        this.salary = salary;
        this.submissionDeadline = submissionDeadline;
        this.details = details;
    }

    @Id
    private String id;
    private String name;
    private String companyName;
    private String location;
    private String salary;
    private Date submissionDeadline;
    private JobDetails details;


}

