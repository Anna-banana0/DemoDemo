package com.employee.payroll.repository;

import com.employee.payroll.model.InvalidEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidEmployeeRepository extends JpaRepository<InvalidEmployee,String> {
}
