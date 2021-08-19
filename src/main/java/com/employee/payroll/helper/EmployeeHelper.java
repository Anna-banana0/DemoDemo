package com.employee.payroll.helper;

import com.employee.payroll.model.Employee;
import com.employee.payroll.model.InvalidEmployee;
import com.employee.payroll.service.RepositoryServiceImpl;
import com.employee.payroll.vo.Pair;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeHelper {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeHelper.class);
    @Autowired
    static RepositoryServiceImpl repositoryServiceImpl;

    public static List getExcelRow(Iterator<Cell> cellsInARow) throws ParseException {
        logger.debug("Inside method: EmployeeHelper.getExcelRow");
        List<String> employeeRow = new ArrayList<>();
        while (cellsInARow.hasNext()) {
            Cell currentCell = cellsInARow.next();
            // reading the row cells
            DataFormatter df = new DataFormatter();
            String value = df.formatCellValue(currentCell);
            employeeRow.add(value);
        }
        return employeeRow;
    }

    public static Pair<List<Employee>,List<InvalidEmployee>> excelFileReader(Workbook workbook) throws IOException, ParseException {
        Sheet sheet = workbook.getSheet(workbook.getSheetName(0));
        List<List<String>> employees = new ArrayList<>();
        Iterator<Row> rows = sheet.iterator();
        while (rows.hasNext()) {
            Row currentRow = rows.next();
            if (currentRow.getRowNum() == 0) {
                continue;// skip first row, as it contains column names
            }
            Iterator<Cell> cellsInARow = currentRow.iterator();
            //read each cell in a row
            logger.debug("calling row reader method EmployeeHelper.getExcelRow");
            employees.add(EmployeeHelper.getExcelRow(cellsInARow));
        }
        // validate all employee list
        logger.debug("calling method :FileValidations.checkFieldValidations");
        Pair<List<Employee>,List<InvalidEmployee>> allEmployees = FileValidations.checkFieldValidations(employees);
        return allEmployees;
    }

    public static void writeToExcel(List<InvalidEmployee> invalidEmployees,FileOutputStream outputStream) throws IOException {
        logger.debug("Writing invalid data in excel sheet");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Error Sheet");
        //To avoid "variable might not have been initialized"
        int rowCount = 0;
        for(InvalidEmployee oneInvalid : invalidEmployees){
            List<String> oneemployee = oneInvalid.getAllFields(oneInvalid);
            Row row = sheet.createRow(++rowCount);
            int columnCount = 0;
            for(String cellValue :oneemployee){
                Cell cell = row.createCell(++columnCount);
                cell.setCellValue(cellValue);
            }
        }
        workbook.write(outputStream);
    }
    public static File convertMultiPartToFile(MultipartFile file) throws IOException {
        logger.debug("Inside method: convertMultiPartToFile");
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}