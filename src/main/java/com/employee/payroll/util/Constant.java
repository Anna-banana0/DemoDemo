package com.employee.payroll.util;

public class Constant {
    public static final  String paySlipHeading = "PAY SLIP";
    public static final String pdfComputerGeneratedPaySlip = "This is computer generated payslip";
    public static final String[] EXTENSIONS_ALLOWED = {"xls","xlsx","cvs","tsv"};
    public static final String EMPID_VALIDATOR = "PS";
    public static final String DOB_VALIDATOR = "MM/dd/yyyy";
    public static final String EMAIL_VALIDATOR = "^(.+)@(\\S+)$";
    public static final int TOTAL_EXCEL_COLUMNS = 9;
    public enum FieldIndex {ID_INDEX,NAME_INDEX,ADDRESS_INDEX,DOB_INDEX,EMAIL_INDEX,ACCNO_INDEX,DESIGNATION_INDEX,STRUCTURE_ID_INDEX,DEPARTMENT_NAME_INDEX};
    public static final String EXCEL_ERROR_SHEET_PATH = "/home/perennial-java/Downloads/SME Employee Payroll - Design and Document (1).xlsx";
    public static final int NO_OF_THREADS = 3;
    public static final int QUEUE_CAPACITY = 100;

}
