package com.employee.payroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="department")
public class Department {
    @Id
    @Column(name = "department_id",unique = true, columnDefinition = "SMALLINT(4)")
    private int departmentId;
    @Column(name = "department_name", nullable = false,columnDefinition = "VARCHAR(10)")
    private String departmentName;
    //@OneToMany()
    //private List<Employee> employees;
}
