package com.epam.framework.browsers;

import com.epam.framework.enums.DriverType;
import com.epam.framework.exceptions.UnsupportedBrowserException;
import org.openqa.selenium.WebDriver;

public class BrowserConfiguration {

    // Utility should be made private to restrict the modification
    private BrowserConfiguration(){}

    public static WebDriver getDriverInstance( DriverType driverType) {

        switch(driverType){

            case CHROME:
                return ChromeBrowser.getbrowserManager().getChromeBrowser();

            case EDGE:
                return EdgeBrowser.getBrowserManager().getEdgeBrowser();

            default:
                throw new UnsupportedBrowserException("not a browser");
        }
    }

}