package com.employee.payroll.repository;

import com.employee.payroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findEmployeeByEmpId(String empId);
    String findAddressByEmpId(String empId);
}
