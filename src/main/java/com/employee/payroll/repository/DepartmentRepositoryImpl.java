package com.employee.payroll.repository;

import com.employee.payroll.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DepartmentRepositoryImpl implements DepartmentRepository {
   @Autowired
    DepartmentRepository departmentRepository;

   public Department getOneDepartment(String departmentName){
       return departmentRepository.findDepartmentByDepartmentName(departmentName);
   }
}
