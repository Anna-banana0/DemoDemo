package com.employee.payroll.handler;

import com.employee.payroll.service.EmployeeDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SMEHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmployeeDetailService employeeDetailService;

    // calling the employee service class to save the file in database
    public void saveFile(MultipartFile[] files) {
        logger.debug("Inside save file handler method");
        //employeeDetailService.saveToDatabase(file);
        employeeDetailService.storeInDB(files);
        logger.debug("End of save file handler method");
    }
}
