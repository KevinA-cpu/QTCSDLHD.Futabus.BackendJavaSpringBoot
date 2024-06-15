package com.heisenburg.backend.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class DetailsDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "ID number is required")
    private String idNumber;

    @NotNull(message = "Birth date is required")
    private Date birthDate;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Education level is required")
    private String educationLevel;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "District is required")
    private String district;

    @NotBlank(message = "Address is required")
    private String address;

    @Email(message = "Email should be valid")
    private String email;

    private String introduction;
}
