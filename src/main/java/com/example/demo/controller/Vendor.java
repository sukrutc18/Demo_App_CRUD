package com.example.demo.controller;

import com.example.demo.exception.RecordNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice(basePackages = "com.example.demo.controller")
public class Vendor extends ResponseEntityExceptionHandler {
    private static final Logger logger = LogManager.getLogger(Vendor.class);
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> handleEntityAlreadyExistsException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No records found");
    }
}
