package com.employee.payroll.controller;

import com.employee.payroll.handler.PayrollHandler;
import com.employee.payroll.handler.PayrollHandlerImpl;
import com.employee.payroll.model.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pay-slip")
public class PayrollController {

    @Autowired
    PayrollHandler payrollHandler;

    @GetMapping
    public List<Payroll> getPayroll(){
        return payrollHandler.getPayroll();
    }

    @PostMapping
    public void addPayroll(@RequestBody Payroll payroll){
        payrollHandler.setPayroll(payroll);
    }

    @PutMapping
    public void editPayroll(@RequestBody Payroll payroll){
        payrollHandler.editPayroll(payroll);
    }

    @DeleteMapping
    public void deletePayroll(@RequestBody Payroll payroll){
        //TODO: soft deletion with column
        payrollHandler.deletePayroll(payroll);
    }

}
