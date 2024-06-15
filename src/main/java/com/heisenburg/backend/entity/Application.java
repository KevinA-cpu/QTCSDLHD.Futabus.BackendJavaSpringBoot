package com.heisenburg.backend.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "applications")
public class Application {
    @Id
    private String id;
    private String job;
    private String jobName;
    private String code;
    private Details details;

    @CreatedDate
    private Date createdAt;

    private String status;
}

