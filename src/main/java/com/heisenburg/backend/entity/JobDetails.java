package com.heisenburg.backend.entity;

import lombok.Data;

@Data
public class JobDetails {
    public JobDetails(String rank, int amount, String form, String experience, String field, String description, String requirements, String documents, String contacts) {
        this.rank = rank;
        this.amount = amount;
        this.form = form;
        this.experience = experience;
        this.field = field;
        this.description = description;
        this.requirements = requirements;
        this.documents = documents;
        this.contacts = contacts;
    }

    private String rank;
    private int amount;
    private String form;
    private String experience;
    private String field;
    private String description;
    private String requirements;
    private String documents;
    private String contacts;

}
