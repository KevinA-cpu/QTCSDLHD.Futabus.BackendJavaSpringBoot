package com.heisenburg.backend.exceptions;

import lombok.Data;

@Data
public class ErrorVO {
    private  String status;
    private  String message;

    public ErrorVO(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
