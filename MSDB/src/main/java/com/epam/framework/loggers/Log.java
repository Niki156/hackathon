package com.epam.framework.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


public class Log {

    private Log(){}

    public static final  Logger LOGGER = LogManager.getLogger("binary-data-logger");

    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logInfo(Object object) {
        LOGGER.info(object);
    }

    public static void logScreenShotToReportPortal(File file, String message) {
        LOGGER.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath(), message);
    }

    public static void logDebug(String message) {
        LOGGER.debug(message);
    }


}