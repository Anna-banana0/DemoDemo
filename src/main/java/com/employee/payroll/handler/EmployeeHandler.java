package com.employee.payroll.handler;

import com.employee.payroll.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeHandler {
    public void setEmployee(Employee employee);
    public List<Employee> getEmployee();
    public void editEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
