package com.employee.payroll.helper;

import com.employee.payroll.model.Department;
import com.employee.payroll.model.Employee;
import com.employee.payroll.model.InvalidEmployee;
import com.employee.payroll.repository.DepartmentRepository;
import com.employee.payroll.util.Constant;
import com.employee.payroll.vo.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FileValidations {
    private static final Logger logger = LoggerFactory.getLogger(FileValidations.class);
    static DepartmentRepository departmentRepository;
    @Qualifier("deptRepository")
    @Autowired
    DepartmentRepository adepartmentRepository;
    // checkFileExtension method to validate the file extension
    public static boolean checkFileExtension(MultipartFile file) throws IOException {
        logger.debug("Inside method: FileValidations.checkFileExtension");
        //convert multipart file to file
        File eFile = EmployeeHelper.convertMultiPartToFile(file);
        //get filename
        String fileName = eFile.getName();
        String extension = null;
        // get the extension from filename
        int i = fileName.lastIndexOf('.');
        if (i >= 0) {
            extension = fileName.substring(i + 1);
        }
        //checking if extension matched with allowed extensions
        for (String s : Constant.EXTENSIONS_ALLOWED) {
            if (extension.equals(s)) {
                return true;
            }
        }
        return false;
    }

    // checkFileSize method to validate if given file is not empty
    public static boolean checkFileSize(MultipartFile file) throws IOException {
        logger.debug("Inside method: FileValidations.checkFileSize");
        //converting multipart file to file
        File eFile = EmployeeHelper.convertMultiPartToFile(file);
        //Checking for empty file
        return eFile.length() == 0;
    }

    public static Employee makeValidEntity(List<String> oneEmployee) throws ParseException {
        logger.debug("Inside method: FileValidations.makeValidEntity");
        Department tempDepartment = new Department();
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DOB_VALIDATOR);
        sdf.setLenient(false);
        Employee tempEmp = new Employee();
        tempEmp.setEmpId(oneEmployee.get(Constant.FieldIndex.ID_INDEX.ordinal()));
        tempEmp.setEmpName(oneEmployee.get(Constant.FieldIndex.NAME_INDEX.ordinal()));
        tempEmp.setEmpAddress(oneEmployee.get(Constant.FieldIndex.ADDRESS_INDEX.ordinal()));
        tempEmp.setEmpDOB(sdf.parse(oneEmployee.get(Constant.FieldIndex.DOB_INDEX.ordinal())));
        tempEmp.setEmpEmail(oneEmployee.get(Constant.FieldIndex.EMAIL_INDEX.ordinal()));
        tempEmp.setEmpAccountNumber(Integer.parseInt(oneEmployee.get(Constant.FieldIndex.ACCNO_INDEX.ordinal())));
        tempEmp.setEmpDesignation(oneEmployee.get(Constant.FieldIndex.DESIGNATION_INDEX.ordinal()));
        tempEmp.setStructureId(oneEmployee.get(Constant.FieldIndex.STRUCTURE_ID_INDEX.ordinal()));
        tempDepartment = departmentRepository.findDepartmentByDepartmentName(oneEmployee.get(Constant.FieldIndex.DEPARTMENT_NAME_INDEX.ordinal()));
        tempEmp.setDepartment(tempDepartment);
        return tempEmp;
    }

    public static Pair<List<Employee>,List<InvalidEmployee>> checkFieldValidations(List<List<String>> employees) throws ParseException {
        int count = 0;
        List<Employee> validList = new ArrayList<>();
        List<InvalidEmployee> invalidList = new ArrayList<>();
        String errors = "1.";
        // looping through the lists
        for (List<String> tempEmp : employees) {
            for (String fieldValue : tempEmp) {
                if (checkEachField(fieldValue)) {
                    count++;
                } else {
                   errors += fieldValue + ",";
                }
            }
            if (count < Constant.TOTAL_EXCEL_COLUMNS) {
                 tempEmp.add(errors); // add errors field in the list of string
                 InvalidEmployee emp = new InvalidEmployee(tempEmp); // send the list as constructor parameter
                invalidList.add(emp);
            } else {
                logger.debug("Calling method:makeValidEntity to store valid data");
                Employee emp = makeValidEntity(tempEmp);
                validList.add(emp);
            }
            count = 0;
        }
        Pair<List<Employee>,List<InvalidEmployee>> allEmployees = new Pair<>(validList,invalidList);
        return allEmployees;
    }

    public static boolean validateEmpId(String empId) {
        return (empId.startsWith(Constant.EMPID_VALIDATOR));
    }

    public static boolean validateEmpDOB(String empDOB) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DOB_VALIDATOR);
        sdf.setLenient(false);
        try {
            Date javaDate = sdf.parse(empDOB);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean validateEmpEmail(String empEmailId) {
        Pattern pattern = Pattern.compile(Constant.EMAIL_VALIDATOR);
        Matcher matcher = pattern.matcher(empEmailId);
        return (matcher.matches());
    }

    public static boolean checkEachField(String fieldValue) {
        boolean checkvalidation = false;
        Constant.FieldIndex[] fields = Constant.FieldIndex.values();
        for (Constant.FieldIndex fieldIdx : fields) {
            switch (fieldIdx) {
                case ID_INDEX:
                    checkvalidation = validateEmpId(fieldValue);
                    break;
                case NAME_INDEX:
                case DEPARTMENT_NAME_INDEX:
                case STRUCTURE_ID_INDEX:
                case DESIGNATION_INDEX:
                case ACCNO_INDEX:
                case ADDRESS_INDEX:
                    checkvalidation = true;
                    break;
                case DOB_INDEX:
                    checkvalidation = validateEmpDOB(fieldValue);
                    break;
                case EMAIL_INDEX:
                    checkvalidation = validateEmpEmail(fieldValue);
                    break;
            }
            break; // to loop out of the Constant.fieldIdx
        }
        return checkvalidation;
    }

    @PostConstruct
    private void initStaticDepartmentRepo() {
        departmentRepository = this.adepartmentRepository;
    }
}