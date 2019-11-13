package ru.itmo.Lab4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PointNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PointNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pointNotFoundHandler(PointNotFoundException ex) {
        return ex.getMessage();
    }
}
