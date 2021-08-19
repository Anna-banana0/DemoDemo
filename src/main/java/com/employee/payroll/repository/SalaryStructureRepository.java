package com.employee.payroll.repository;

import com.employee.payroll.model.SalaryStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryStructureRepository extends JpaRepository<SalaryStructure, String> {
}
