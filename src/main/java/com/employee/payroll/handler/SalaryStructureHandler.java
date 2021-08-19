package com.employee.payroll.handler;

import com.employee.payroll.model.SalaryStructure;

import java.util.List;

public interface SalaryStructureHandler {
    public void setGrade(SalaryStructure grade);
    public List<SalaryStructure> getGrades();
    public void editGrade(SalaryStructure grade);
    public void deleteGrade(SalaryStructure grade);
}
