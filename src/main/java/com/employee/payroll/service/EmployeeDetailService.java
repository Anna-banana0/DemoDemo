package com.employee.payroll.service;

import com.employee.payroll.exception.UploadFileExceptions;
import com.employee.payroll.helper.DBStorage;
import com.employee.payroll.helper.ExcelToEmployee;
import com.employee.payroll.helper.FilePickupThread;
import com.employee.payroll.model.Employee;
import com.employee.payroll.model.FileDetails;
import com.employee.payroll.model.InvalidEmployee;
import com.employee.payroll.repository.EmployeeRepository;
import com.employee.payroll.repository.FileDetailRepository;
import com.employee.payroll.repository.InvalidEmployeeRepository;
import com.employee.payroll.vo.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeDetailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private InvalidEmployeeRepository invalidEmployeeRepository;
    @Autowired
    private FileDetailRepository fileDetailRepository;

    public void saveToDatabase(MultipartFile file) {
        logger.debug("Inside saveToDatabse service method");
            logger.debug("Saving <value> valid employee in employee table");
            employeeRepository.saveAll(DBStorage.collectEntities(file).getValid());
            logger.debug("Saving invalid employee in invalidEmployeeRepository");
            invalidEmployeeRepository.saveAll(DBStorage.collectEntities(file).getInvalid());
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void storeInDB(MultipartFile[] files) {
        List<FileDetails> allFiles = DBStorage.collectAllFiles(files);
        fileDetailRepository.saveAll(allFiles);
        logger.debug("Files received and going for processing");
    }
}