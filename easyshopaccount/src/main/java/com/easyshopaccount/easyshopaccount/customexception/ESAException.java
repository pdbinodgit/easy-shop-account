package com.easyshopaccount.easyshopaccount.customexception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ESAException extends RuntimeException{
    private String message;
    private HttpStatus status;
    private int code;

    public ESAException(String message, HttpStatus status, int code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }
}
