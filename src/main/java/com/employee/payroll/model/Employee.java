package com.employee.payroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {
    @Id
    @Column(name = "employee_id",unique = true,columnDefinition = "VARCHAR(10)")
    private String empId;
    @Column(name = "employee_name", nullable = false,columnDefinition = "VARCHAR(50)")
    private String empName;
    @Column(name = "employee_address", nullable = false,columnDefinition = "VARCHAR(100)")
    private String empAddress;
    @Column(name = "employee_dob", nullable = false)
    private Date empDOB;
    @Column(name = "employee_email", nullable = false,columnDefinition = "VARCHAR(50)")
    @Email(message = "Email should be valid")
    private String empEmail;
    @Column(name = "employee_account_number", nullable = false, columnDefinition = "BIGINT(15)")
    private int empAccountNumber;
    @Column(name = "employee_designation", nullable = false,columnDefinition = "VARCHAR(15)")
    private String empDesignation;
    @Column(name = "structure_id", nullable = false, columnDefinition = "VARCHAR(10)")
    private String structureId; // not null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id",nullable = false,columnDefinition = "SMALLINT(4)")
    private Department department;
}
