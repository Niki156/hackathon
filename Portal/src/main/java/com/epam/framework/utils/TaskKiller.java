package com.epam.framework.utils;

import com.epam.framework.base.TestBase;
import com.epam.framework.loggers.Log;

import java.io.IOException;

import static com.epam.hackathon.constants.ConstantsSetUp.*;


public class TaskKiller  extends TestBase {
    Process p;

    public void killTask(String filePath) {
        try {
            p = Runtime.getRuntime().exec(filePath);
        } catch (IOException e) {
            Log.logInfo(e.getMessage());
        }
    }

    public static void terminate(){
            new TaskKiller().killTask(CHROME_KILL_BAT);
            Log.logInfo("killed chromedriver.exe");
    }
}

