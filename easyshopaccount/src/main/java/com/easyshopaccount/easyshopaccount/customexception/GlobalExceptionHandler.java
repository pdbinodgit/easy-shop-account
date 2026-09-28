package com.easyshopaccount.easyshopaccount.customexception;

import com.easyshopaccount.easyshopaccount.customresponse.ESAResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ESAException.class)
    public ResponseEntity<ESAResponse<?>> esaException(ESAException esaException, WebRequest webRequest){
        return ResponseEntity.status(
                esaException.getStatus()
        ).body(new ESAResponse<>(esaException.getStatus(), esaException.getMessage(), LocalDateTime.now()));
    }
}
