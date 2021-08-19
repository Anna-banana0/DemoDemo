package com.employee.payroll.handler;

import com.employee.payroll.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentHandler {
    public void setDepartment(Department department);
    public List<Department> getDepartment();
    public  Department findDepartmentByDepartmentName(String departmentName);
    public void editDepartment(Department department);
    public void deleteDepartment(Department department);
}
