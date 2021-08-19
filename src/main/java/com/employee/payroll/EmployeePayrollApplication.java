package com.employee.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmployeePayrollApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeePayrollApplication.class, args);
  }

  @GetMapping("/hello")
  public String sayHello() {
    return String.format("Started SME Employee Payroll");
  }
}
