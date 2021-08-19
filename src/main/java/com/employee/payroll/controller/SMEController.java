package com.employee.payroll.controller;

import com.employee.payroll.handler.SMEHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class SMEController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SMEHandler smeHandler;

    //Get request for home page
    @GetMapping("/home")
    public String displayHomePage() {
        logger.debug("Inside home page controller");
        return "Hi, this is Homepage";
    }

    // post request to upload the excel file
    @PostMapping(name = "/upload-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestPart("files") MultipartFile[] files) {
            logger.debug("Inside uploadFile controller");
            smeHandler.saveFile(files);
        return ResponseEntity.ok("File uploaded");
    }
}
