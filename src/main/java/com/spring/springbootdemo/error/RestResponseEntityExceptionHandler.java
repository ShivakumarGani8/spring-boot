package com.spring.springbootdemo.error;

import com.spring.springbootdemo.controller.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException exceptioon){
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND,exceptioon.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception exceptioon){
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exceptioon.getMessage());
        return errorMessage;
    }
}
