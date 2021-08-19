package com.employee.payroll.handler;

import com.employee.payroll.exception.ResourceNotFoundException;
import com.employee.payroll.model.Payroll;
import com.employee.payroll.repository.PayrollRepository;
import com.employee.payroll.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollHandlerImpl implements PayrollHandler{

    @Autowired
    PayrollRepository payrollRepository;

    @Autowired
    RepositoryService service;

    public void setPayroll(Payroll payroll){
        service.setPayroll(payroll);
    }

    public List<Payroll> getPayroll(){
        return service.getPayroll();
    }
    public void editPayroll(Payroll payroll){
        Payroll payrollFetch = payrollRepository.findPayrollByTransactionId(payroll.getTransactionId());
        if(payrollFetch == null){
            throw new ResourceNotFoundException("Cannot find Payroll in the database");
        }
        service.editPayroll(payroll);
    }
    public void deletePayroll(Payroll payroll){
        service.deletePayroll(payroll);
    }
}
