package com.heisenburg.backend.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
public class ApplicationDTO {
    @NotBlank(message = "Job is required")
    private String job;

    private String jobName;

    @Valid
    private DetailsDTO details;
}

