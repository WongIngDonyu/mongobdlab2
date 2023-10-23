package com.example.mongodblab2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EnclosuresNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(EnclosuresNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reviewNotFoundHandler(EnclosuresNotFoundException ex) {
        return ex.getMessage();
    }
}
