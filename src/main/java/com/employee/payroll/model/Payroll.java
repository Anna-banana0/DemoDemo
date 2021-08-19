package com.employee.payroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Month;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payroll")
public class Payroll {
    @Id
    @Column(name = "transaction_id",columnDefinition = "VARCHAR(15)")
    private String transactionId;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id",nullable = false)
    private Employee employee;
    @Column(name = "payroll_month", nullable = false, columnDefinition = "TINYINT(2)")
    private int month;
    @Column(name = "payable_days", nullable = false, columnDefinition = "TINYINT(2)")
    private int payableDays;
    @Column(name = "total_days", nullable = false, columnDefinition = "TINYINT(2)")
    private int totalDays;

}
