package com.employee.payroll.helper;

import com.employee.payroll.exception.UploadFileExceptions;
import com.employee.payroll.model.Employee;
import com.employee.payroll.model.InvalidEmployee;
import com.employee.payroll.util.Constant;
import com.employee.payroll.vo.Pair;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public class ExcelToEmployee {
    private static final Logger logger = LoggerFactory.getLogger(ExcelToEmployee.class);
    // method to read excel file and store values.
    @Async
    public static Pair<List<Employee>,List<InvalidEmployee>> fileToEmployee(InputStream is, MultipartFile file) throws UploadFileExceptions.InvalidFileSizeException, UploadFileExceptions.InvalidFileExtensionException {
        Pair<List<Employee>,List<InvalidEmployee>> allEmployees ;
        try {
            // check for file size not empty
            if (FileValidations.checkFileSize(file)) {
                logger.error("InvalidFileSizeException");
                throw new UploadFileExceptions.InvalidFileSizeException("No file inserted/ the file is empty");
            }
                //check for file allowed file extensions
            if (!FileValidations.checkFileExtension(file)) {
                logger.error("InvalidFileExtensionException");
                throw new UploadFileExceptions.InvalidFileExtensionException("Allowed file types: xls,xlsx,cvs,tvs");
            }
            //opening a the workbook
            Workbook workbook = new XSSFWorkbook(is);
            //calling the employee helper class to read from excel
            logger.debug("Calling excel file reader method EmployeeHelper.excelFileReade");
            allEmployees = EmployeeHelper.excelFileReader(workbook);
            //writing invalid employess in excel
            FileOutputStream outputStream = new FileOutputStream(Constant.EXCEL_ERROR_SHEET_PATH);
            logger.debug("Calling method :EmployeeHelper.writeToExcel");
            EmployeeHelper.writeToExcel(allEmployees.getInvalid(),outputStream);
            workbook.close();
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Fail to parse excel file: " + e.getMessage());
        }
        return allEmployees;
    }
}