/*

package com.employee.payroll.helper;

import com.employee.payroll.util.PDFProperties;
import com.employee.payroll.model.Payroll;
import com.employee.payroll.util.Constant;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PdfHelper {

    String outputFilePath;
    Document document;
    @Autowired
    Payroll payroll;
    @Autowired
    PDFHandlerImpl pdfHandler;
    @Autowired
    PDFProperties pdfData;
    String empId;
    List<String> titleInformation;
    List<String> employeeInformation;
    List<String> accountInformation;
    */
/*pdfPrinter
        pdfDisplay
     *//*


    public PdfHelper(String filePath, String empId, PDFProperties pdfProperties, List<String> titleInformation, List<String> employeeInformation, List<String> accountInformation) throws FileNotFoundException, DocumentException {
        outputFilePath = filePath;
        document = new Document(PageSize.A4);
        this.titleInformation = titleInformation;
        this.employeeInformation = employeeInformation;
        this.accountInformation = accountInformation;
        PdfWriter.getInstance(document, new FileOutputStream(outputFilePath));
        this.empId = empId;
    }

    public void export() throws DocumentException {
        document.open();
        exportTitle(titleInformation);
        exportEmployeeInformation(employeeInformation);
        exportAccountInformation(accountInformation);
        document.close();
    }

    public void exportTitle(List<String> titleInformation) throws DocumentException {
        //logo
        //String address = "Perennial Systems\n" + "Office#1, Mahavir Park Complex,\n" + "5th Floor, Pune-Satara Road,\n" + " Pune 411037";
        String companyAddress = "Hello"; //pdfHandler.getEmployeeAddress(empId); //do Company Address
        Paragraph paragraph = new Paragraph(companyAddress);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);
    }

    public void exportAccountInformation(List<String> accountInformation) throws DocumentException {

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        accountInformation.add("a");
        accountInformation.add("b");
        PdfPTable table = getTableWithProperties(2);

        for(String str : accountInformation){
            table = printCellPDF(table,str);
        }
        document.add(table);
        Paragraph paragraph = getParagraph(Constant.pdfComputerGeneratedPaySlip);
        document.add(paragraph);
    }

    public void exportEmployeeInformation(List<String> employeeInformation) throws DocumentException {

        //Take list and input and print it using PdfCell
        Paragraph paragraph = getParagraph(Constant.paySlipHeading);
        Paragraph paragraph2 = getParagraph("ABCD");//getParagraph(pdfHandler.getEmployeeAddress(empId));

        document.add(paragraph);
        document.add(paragraph2);

        List<String> objectList = new ArrayList<>();
        PdfPTable table = getTableWithProperties(4);

        for(String str : objectList){
            table = printCellPDF(table,str);
        }

        document.add(table);
    }

    public PdfPTable printCellPDF(PdfPTable table, String string) throws DocumentException {
        PdfPCell cell = getPDFPCellWithProperties(string);
        table.addCell(cell);
        return table;
    }

    public PdfPTable getTableWithProperties(int columns) throws DocumentException {
        PdfPTable table = new PdfPTable(columns);
        table.setWidthPercentage(100);
        table.setSpacingAfter(10);
        table.setSpacingBefore(10);
        return table;
    }

    public Paragraph getParagraph(String string){
        Font fontTitle = FontFactory.getFont(pdfData.getTitleFont());
        fontTitle.setSize(pdfData.getTitleFontSize());
        Font fontParagraph = FontFactory.getFont(pdfData.getParagraphFont());
        fontParagraph.setSize(pdfData.getParagraphFontSize());

        Paragraph paragraph = new Paragraph(string, fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        return paragraph;
    }


    public PdfPCell getPDFPCellWithProperties(String string){
        PdfPCell cell = new PdfPCell(new Paragraph(string));
        cell.setPaddingLeft(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }


public void generatePDF() throws Exception {
        Document doc = new Document();
        File file = new File("C://New folder//itext_Test.pdf");
        FileOutputStream pdfFileout = new FileOutputStream(file);
        PdfWriter.getInstance(doc, pdfFileout);
        doc.open();
        Paragraph para = new Paragraph("Test");
        doc.add(catPart);
        doc.close();
    }


}

*/
