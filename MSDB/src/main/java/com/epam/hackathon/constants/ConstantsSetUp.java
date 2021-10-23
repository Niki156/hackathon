package com.epam.hackathon.constants;

public class ConstantsSetUp {
        private ConstantsSetUp(){}
        public static final String PROJECT_SOURCE_PATH=System.getProperty("user.dir");
        public static final String CHROMEDRIVER_SYSTEM_PROPERTY="webdriver.chrome.driver";
        public static final String CHROMEDRIVER_SYSTEM_PATH=PROJECT_SOURCE_PATH+"\\src\\test\\resources\\chromedriver.exe";
        public static final String EDGEDRIVER_SYSTEM_PROPERTY="webdriver.edge.driver";
        public static final String EDGEDRIVER_SYSTEM_PATH=PROJECT_SOURCE_PATH+"\\src\\test\\resources\\msedgedriver.exe";
        public static int TIME_OUT_SECONDS;
        public static final String SCREENSHOTS_LOCATION="";
}
