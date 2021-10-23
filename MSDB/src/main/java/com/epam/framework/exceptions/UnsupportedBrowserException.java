package com.epam.framework.exceptions;

import com.epam.framework.loggers.Log;

public class UnsupportedBrowserException extends RuntimeException {
    public UnsupportedBrowserException(String message) {
        super(message);
        Log.logInfo(message);
    }
}
