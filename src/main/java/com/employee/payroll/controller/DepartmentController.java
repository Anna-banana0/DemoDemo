package com.employee.payroll.controller;

import com.employee.payroll.handler.DepartmentHandler;
import com.employee.payroll.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    DepartmentHandler departmentHandler;

    @GetMapping
    public List<Department> getDepartment() {
        return departmentHandler.getDepartment();
    }

    @PostMapping
    public void setDepartment(@RequestBody Department department) {
        departmentHandler.setDepartment(department);
    }

    @GetMapping("/{departmentName}")
    public Department getDepatmentByDepartmentName(@PathVariable String departmentName) {
        return departmentHandler.findDepartmentByDepartmentName(departmentName);
    }

    @PutMapping
    public void editDepartment(@RequestParam Department department) {
        departmentHandler.editDepartment(department);
    }

    @DeleteMapping
    public void deleteDepartment(@RequestBody Department department) {
        departmentHandler.deleteDepartment(department);
    }
}
