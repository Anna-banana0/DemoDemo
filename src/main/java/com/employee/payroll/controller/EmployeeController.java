package com.employee.payroll.controller;

import com.employee.payroll.handler.EmployeeHandler;
import com.employee.payroll.handler.EmployeeHandlerImpl;
import com.employee.payroll.model.Department;
import com.employee.payroll.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employees")
public class EmployeeController {

    @Autowired
    EmployeeHandler employeeHandler;

    @GetMapping
    public List<Employee> getEmployee(){
        return employeeHandler.getEmployee();
    }

    @PostMapping
    public void setEmployee(@RequestBody Employee employee){
        employeeHandler.setEmployee(employee);
    }

    @PutMapping
    public void editEmployee(@RequestBody Employee employee){
        employeeHandler.editEmployee(employee);
    }

    @DeleteMapping
    public void deleteEmployee(@RequestBody Employee employee){
        employeeHandler.deleteEmployee(employee);
    }
}
