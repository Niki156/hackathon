package com.epam.framework.exceptions;

import com.epam.framework.loggers.Log;

public class ExcelsheetException extends RuntimeException {
    public ExcelsheetException(String message) {
        super(message);
        Log.logInfo(message);
    }
}
