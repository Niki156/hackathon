package com.epam.framework.browsers;

import static com.epam.hackathon.constants.ConstantsSetUp.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser {

    private static EdgeBrowser edgeBrowserInstance = new EdgeBrowser();
    // making constructor private (singleton pattern)
    private EdgeBrowser() {
        System.setProperty(EDGEDRIVER_SYSTEM_PROPERTY,EDGEDRIVER_SYSTEM_PATH);
    }
    public static EdgeBrowser getBrowserManager() {
        return edgeBrowserInstance;
    }
    public WebDriver getEdgeBrowser() {
        return new EdgeDriver();
    }
}
