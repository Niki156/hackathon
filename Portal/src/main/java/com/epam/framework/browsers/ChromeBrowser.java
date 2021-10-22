package com.epam.framework.browsers;

import static com.epam.hackathon.constants.ConstantsSetUp.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

    private static ChromeBrowser chromeBrowserInstance = new ChromeBrowser();
    // making constructor private (Singleton class)
    private ChromeBrowser() {
        System.setProperty(CHROMEDRIVER_SYSTEM_PROPERTY,CHROMEDRIVER_SYSTEM_PATH);
    }
    public static ChromeBrowser getbrowserManager() {
        return chromeBrowserInstance;
    }

    public WebDriver getChromeBrowser() {
        return new ChromeDriver();
    }
}

