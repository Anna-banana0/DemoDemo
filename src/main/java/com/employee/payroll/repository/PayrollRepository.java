package com.employee.payroll.repository;

import com.employee.payroll.model.Employee;
import com.employee.payroll.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll,String> {
    Payroll findPayrollByTransactionId(String transactionId);
}
