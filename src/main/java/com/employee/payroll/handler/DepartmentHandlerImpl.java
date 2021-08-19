package com.employee.payroll.handler;

import com.employee.payroll.model.Department;
import com.employee.payroll.repository.DepartmentRepository;
import com.employee.payroll.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentHandlerImpl implements DepartmentHandler {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    RepositoryService service;

    public List<Department> getDepartment() {
        return service.getDepartment();
    }

    public void setDepartment(Department department) {
        service.setDepartment(department);
    }

    @Override
    public Department findDepartmentByDepartmentName(String departmentName) {
        return service.findDepartmentByDepartmentName(departmentName);
    }

    public void editDepartment(Department department) {
        service.editDepartment(department);
    }

    public void deleteDepartment(Department department) {
        service.deleteDepartment(department);
    }
}
