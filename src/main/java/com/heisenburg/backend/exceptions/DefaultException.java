package com.heisenburg.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DefaultException extends RuntimeException {
    private String status;
    private String message;

    public DefaultException(API_STATUSES apiSTATUSES) {
        super(apiSTATUSES.getMessage());
        this.status = apiSTATUSES.getStatus();
        this.message = apiSTATUSES.getMessage();
    }

    public DefaultException(String message) {
        super(message);
        API_STATUSES apiStatus = API_STATUSES.valueOf(message);
        this.status = apiStatus.getStatus();
        this.message = apiStatus.getMessage();
    }
}