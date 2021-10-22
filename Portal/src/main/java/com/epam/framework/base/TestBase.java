package com.epam.framework.base;

import com.epam.framework.browsers.BrowserConfiguration;
import com.epam.framework.enums.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.epam.framework.utils.WaitUtilities.waitForElementToBeVisible;
import static com.epam.hackathon.constants.ConstantsSetUp.TIME_OUT_SECONDS;

public class TestBase {
    protected WebDriver driver;
     public  WebDriver launchBrowser(String url,DriverType driverType){
        this.driver=BrowserConfiguration.getDriverInstance(driverType);
        maximizeWindow(driver);
        openUrl(url,driver);
        return driver;
    }
    public static void openUrl(String url,WebDriver driver){
        driver.get(url);
    }
    public String getCurrentPageUrl(WebDriver driver) {
       return driver.getCurrentUrl();
    }
    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }
    public static void closeWindow(WebDriver driver) {
        driver.quit();
    }

    public boolean verifyCurrentPageHeaderTextWithExpectedPageHeaderText(WebDriver driver,String header, String expectedText){
        return waitForElementToBeVisible(driver,TIME_OUT_SECONDS,driver.findElement(By.tagName(header))).getText().equals(expectedText);
    }
    public boolean verifyCurrentPageUrlWithExpectedPageUrl(WebDriver driver,String url)
    {
       return getCurrentPageUrl(driver).equals(url);
    }
}
