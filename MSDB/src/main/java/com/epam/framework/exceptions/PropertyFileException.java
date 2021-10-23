package com.epam.framework.exceptions;

import com.epam.framework.loggers.Log;

public class PropertyFileException extends RuntimeException{
    public PropertyFileException(String message){
        super(message);
        Log.logInfo(message);
    }
}

