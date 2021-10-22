package com.epam.framework.exceptions;

import com.epam.framework.loggers.Log;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String message) {
        super(message);
        Log.logInfo(message);
    }
}
