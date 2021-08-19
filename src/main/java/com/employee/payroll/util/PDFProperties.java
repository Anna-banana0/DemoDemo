package com.employee.payroll.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class PDFProperties {
    int titleFontSize;
    int paragraphFontSize;
    String titleFont;
    String paragraphFont;
    String pageSize;
    String pdfFilePath;
}
