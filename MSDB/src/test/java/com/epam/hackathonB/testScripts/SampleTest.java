package com.epam.hackathonB.testScripts;

import com.epam.framework.base.TestBase;
import com.epam.framework.enums.DriverType;
import com.epam.hackathonB.Web.NSEPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SampleTest extends TestBase{
    @Test()
    public void setup(){
        driver = launchBrowser("https://www.nyse.com/", DriverType.CHROME);
        NSEPage nsePage = new NSEPage(driver);
        nsePage.findSearchWith("EPAM");



    }
}
