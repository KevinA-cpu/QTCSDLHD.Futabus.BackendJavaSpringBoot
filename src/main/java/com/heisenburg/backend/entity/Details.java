package com.heisenburg.backend.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Details {
    private String fullName;
    private String gender;
    private String idNumber;
    private Date birthDate;
    private String phoneNumber;
    private String educationLevel;
    private String city;
    private String district;
    private String address;
    private String email;
    private String introduction;
}
