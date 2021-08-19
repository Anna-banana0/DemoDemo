package com.employee.payroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="salary_structure")
public class SalaryStructure {
    @Id
    @Column(name = "id", unique = true, columnDefinition = "TINYINT(2)")
    private String id;
    @Column(name = "structure_id", nullable = false,columnDefinition ="VARCHAR(10)" )
    private String StructureId;
    @Column(name = "head", nullable = false,columnDefinition = "VARCHAR(10)")
    private String head;
    @Column(name = "amount", nullable = false,columnDefinition = "DOUBLE")
    private Double amount;
    @Column(name = "is_percentage", columnDefinition = "BIT", length = 1,nullable = false)
    private Boolean isPercentage;
    @Column(name = "is_deduction", columnDefinition = "BIT", length = 1,nullable = false)
    private Boolean isDeduction;
//    @OneToMany()
//    private List<Employee> employees;
}
