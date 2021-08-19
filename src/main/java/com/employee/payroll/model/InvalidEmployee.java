package com.employee.payroll.model;

import com.employee.payroll.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invalid_employee")
public class InvalidEmployee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_id")
    private String empId;
    @Column(name = "employee_name")
    private String empName;
    @Column(name = "employee_address")
    private String empAddress;
    @Column(name = "employee_dob")
    private String empDOB;
    @Column(name = "employee_email")
    private String empEmail;
    @Column(name = "employee_account_number")
    private String empAccountNumber;
    @Column(name = "employee_designation")
    private String empDesignation;
    @Column(name = "structure_id")
    private String structureId;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "errors")
    private String errors;

    public InvalidEmployee(List<String> invalidEmployee) throws ParseException {
        this.empId = invalidEmployee.get(Constant.FieldIndex.ID_INDEX.ordinal());
        this.empName = invalidEmployee.get(Constant.FieldIndex.NAME_INDEX.ordinal());
        this.empAddress = invalidEmployee.get(Constant.FieldIndex.ADDRESS_INDEX.ordinal());
        this.empDOB = invalidEmployee.get(Constant.FieldIndex.DOB_INDEX.ordinal());
        this.empEmail = invalidEmployee.get(Constant.FieldIndex.EMAIL_INDEX.ordinal());
        this.empAccountNumber = invalidEmployee.get(Constant.FieldIndex.ACCNO_INDEX.ordinal());
        this.empDesignation = invalidEmployee.get(Constant.FieldIndex.DESIGNATION_INDEX.ordinal());
        this.structureId = invalidEmployee.get(Constant.FieldIndex.STRUCTURE_ID_INDEX.ordinal());
        this.departmentName = invalidEmployee.get(Constant.FieldIndex.DEPARTMENT_NAME_INDEX.ordinal());
        this.errors = invalidEmployee.get(invalidEmployee.size() - 1);
    }

    public List<String> getAllFields(InvalidEmployee employee){
        List<String> allFields = new ArrayList<>();
            allFields.add(employee.getEmpId());
            allFields.add(employee.getEmpName());
            allFields.add(employee.getEmpAddress());
            allFields.add(employee.getEmpDOB());
            allFields.add(employee.getEmpEmail());
            allFields.add(employee.getEmpAccountNumber());
            allFields.add(employee.getEmpDesignation());
            allFields.add(employee.getStructureId());
            allFields.add(employee.getDepartmentName());
            allFields.add(employee.getErrors());
            return allFields;
    }
}
