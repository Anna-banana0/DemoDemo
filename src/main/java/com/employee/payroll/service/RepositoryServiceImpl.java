package com.employee.payroll.service;

import com.employee.payroll.exception.ResourceNotFoundException;
import com.employee.payroll.model.Department;
import com.employee.payroll.model.Employee;
import com.employee.payroll.model.Payroll;
import com.employee.payroll.model.SalaryStructure;
import com.employee.payroll.repository.DepartmentRepository;
import com.employee.payroll.repository.EmployeeRepository;
import com.employee.payroll.repository.PayrollRepository;
import com.employee.payroll.repository.SalaryStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    SalaryStructureRepository gradeRepository;
    @Autowired
    PayrollRepository payrollRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public void setDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentByDepartmentName(String departmentName) {
        return departmentRepository.findDepartmentByDepartmentName(departmentName);
    }

    @Override
    public void editDepartment(Department department) {
        if (departmentRepository.findByDepartmentId(department.getDepartmentId()) == null) {
            throw new ResourceNotFoundException("Department not present in the database");
        }
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void setEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void setGrade(SalaryStructure grade) {
        gradeRepository.save(grade);
    }

    @Override
    public List<SalaryStructure> getGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void editGrade(SalaryStructure grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(SalaryStructure grade) {
        gradeRepository.delete(grade);
    }

    @Override
    public List<Payroll> getPayroll() {
        return payrollRepository.findAll();
    }

    @Override
    public void setPayroll(Payroll payroll) {
        payrollRepository.save(payroll);
    }

    @Override
    public void editPayroll(Payroll payroll) {
        payrollRepository.save(payroll);
    }

    @Override
    public void deletePayroll(Payroll payroll) {
        payrollRepository.delete(payroll);
    }

    public String getEmployeeAddressByEmployeeId(String empId) {
        return employeeRepository.findAddressByEmpId(empId);
    }
}
