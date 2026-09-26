package com.easyshopaccount.easyshopaccount.customresponse;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ESAResponse <T>{
    HttpStatus status;
    String message;
    T data;
    LocalDateTime timestamp;

    public ESAResponse(HttpStatus status, String message, T data, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
