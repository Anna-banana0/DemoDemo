package com.employee.payroll.service;

import com.employee.payroll.model.Department;
import com.employee.payroll.model.Employee;
import com.employee.payroll.model.Payroll;
import com.employee.payroll.model.SalaryStructure;

import java.util.List;

public interface RepositoryService {

    public List<Department> getDepartment();

    public void setDepartment(Department department);

    Department findDepartmentByDepartmentName(String departmentName);

    public void editDepartment(Department department);

    public void deleteDepartment(Department department);

    public List<Employee> getEmployee();

    public void setEmployee(Employee employee);

    public void editEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public void setGrade(SalaryStructure grade);

    public List<SalaryStructure> getGrades();

    public void editGrade(SalaryStructure grade);

    public void deleteGrade(SalaryStructure grade);

    public List<Payroll> getPayroll();

    public void setPayroll(Payroll payroll);

    public void editPayroll(Payroll payroll);

    public void deletePayroll(Payroll payroll);
}
