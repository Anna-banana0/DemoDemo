package com.employee.payroll.controller;

import com.employee.payroll.handler.SalaryStructureHandler;
import com.employee.payroll.model.SalaryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grades")
public class SalaryStructureController {

    @Autowired
    SalaryStructureHandler gradeHandler;

    @GetMapping
    public List<SalaryStructure> getGrade(){
        return gradeHandler.getGrades();
    }

    @PostMapping
    public void setGrade(@RequestBody SalaryStructure grade){
        gradeHandler.setGrade(grade);
    }

    @PutMapping
    public void editGrade(@RequestBody SalaryStructure grade){
        gradeHandler.editGrade(grade);
    }

    @DeleteMapping
    public void deleteGrade(@RequestBody SalaryStructure grade){
        gradeHandler.deleteGrade(grade);
    }
}
