package com.employee.payroll.helper;

import com.employee.payroll.exception.UploadFileExceptions;
import com.employee.payroll.model.Employee;
import com.employee.payroll.model.FileDetails;
import com.employee.payroll.model.InvalidEmployee;
import com.employee.payroll.vo.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBStorage {
    private static final Logger logger = LoggerFactory.getLogger(DBStorage.class);
    public static List<FileDetails> collectAllFiles(MultipartFile[] files) {
        int fileCount = files.length;
        List<FileDetails> multiplefiles = new ArrayList<>();
        for (MultipartFile tempFile : files) {
            FileDetails file = new FileDetails(tempFile.getOriginalFilename(), "Uploaded");
            multiplefiles.add(file);
        }
        FilePickupThread pickup = new FilePickupThread(files,fileCount);
        return multiplefiles;
    }
    public static Pair<List<Employee>, List<InvalidEmployee>> collectEntities(MultipartFile file){
        try {
            logger.debug("calling file reader method to read the input file");
            Pair<List<Employee>, List<InvalidEmployee>> allEmployees = ExcelToEmployee.fileToEmployee(file.getInputStream(), file);
            return allEmployees;
        }catch (IOException e) {
            e.printStackTrace();
        } catch (UploadFileExceptions.InvalidFileSizeException e) {
            e.printStackTrace();
        } catch (UploadFileExceptions.InvalidFileExtensionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
