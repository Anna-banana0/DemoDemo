package com.employee.payroll.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class CustomException {
    private final String message;
    private final HttpStatus httpStatus;
}
