package com.employee.payroll.repository;

import com.employee.payroll.model.Department;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

@Qualifier("deptRepository")
public interface DepartmentRepository extends JpaRepository<Department, String> {
    Department findByDepartmentId(int departmentId);

    Department findDepartmentByDepartmentName(String departmentName);
}
