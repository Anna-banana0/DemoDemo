package com.employee.payroll.handler;

import com.employee.payroll.model.Payroll;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PayrollHandler {
    public void setPayroll(Payroll payroll);
    public List<Payroll> getPayroll();
    public void editPayroll(Payroll payroll);
    public void deletePayroll(Payroll payroll);
}
