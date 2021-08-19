package com.employee.payroll.handler;

import com.employee.payroll.model.Employee;
import com.employee.payroll.model.SalaryStructure;
import com.employee.payroll.repository.EmployeeRepository;
import com.employee.payroll.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeHandlerImpl implements EmployeeHandler{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RepositoryService service;

    public void setEmployee(Employee employee){
        service.setEmployee(employee);
    }

    public List<Employee> getEmployee(){
        return  service.getEmployee();
    }

    public void editEmployee(Employee employee){
        service.editEmployee(employee);
    }
    public void deleteEmployee(Employee employee){
        service.deleteEmployee(employee);
    }
}
