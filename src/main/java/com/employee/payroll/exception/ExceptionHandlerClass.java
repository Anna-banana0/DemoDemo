package com.employee.payroll.exception;

import com.employee.payroll.exception.CustomException;
import com.employee.payroll.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleGradeNotFoundException(ResourceNotFoundException e){
        CustomException gradeException = new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(gradeException, HttpStatus.BAD_REQUEST);
    }
}
