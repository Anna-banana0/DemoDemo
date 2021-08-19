package com.employee.payroll.exception;

public class UploadFileExceptions {
    public static class InvalidFileSizeException extends Exception {

        public InvalidFileSizeException(String s) {
            super(s);
        }
    }

    public static class InvalidFileExtensionException extends Exception {
        public InvalidFileExtensionException(String s) {
            super(s);
        }
    }

}
