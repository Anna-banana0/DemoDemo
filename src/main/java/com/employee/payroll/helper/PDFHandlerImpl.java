/*
package com.employee.payroll.helper;

import com.employee.payroll.util.PDFProperties;
import com.employee.payroll.service.RepositoryService;
import com.employee.payroll.service.RepositoryServiceImpl;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PDFHandlerImpl implements PDFHandler{

    @Autowired
    PDFServiceImpl pdfService;
    @Autowired
    PDFProperties pdfProperties;


    public PDFProperties getProperties(){
        pdfProperties.setTitleFontSize(12);
        pdfProperties.setParagraphFontSize(8);
        return pdfProperties;
    }

    public String getEmployeeAddress(String empId){
        return pdfService.getEmployeeAddress(empId);
    }

    public void setPdfInformation() throws DocumentException, FileNotFoundException {
        List<String> accountInformation = setAccountInformation();;
        List<String> titleInformation = setTitleInformation();
        List<String> employeeInformation = setEmployeeInformation();
        PdfHelper pdfHelper = new PdfHelper("/","edef", pdfProperties, titleInformation, employeeInformation, accountInformation);
        pdfHelper.export();
    }

    public List<String> setAccountInformation(){
        List<String> accountInformation = new ArrayList<>();
        accountInformation.add("ABCD");
        accountInformation.add("ABCD");
        accountInformation.add("ABCD");
        accountInformation.add("ABCD");
        accountInformation.add("ABCD");
        accountInformation.add("ABCD");
        accountInformation.add("ABCD");
        accountInformation.add("ABCD");
        return accountInformation;
    }
    public List<String> setEmployeeInformation(){
        List<String> employeeInformation = new ArrayList<>();
        employeeInformation.add("ABCD");
        employeeInformation.add("ABCD");
        employeeInformation.add("ABCD");
        employeeInformation.add("ABCD");
        employeeInformation.add("ABCD");
        return employeeInformation;
    }

    public List<String> setTitleInformation(){
        List<String> titleInformation = new ArrayList<>();
        titleInformation.add("ABCD");
        titleInformation.add("ABCD");
        titleInformation.add("ABCD");
        titleInformation.add("ABCD");
        titleInformation.add("ABCD");
        return titleInformation;
    }

}
*/
