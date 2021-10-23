package com.epam.hackathon.testScripts;

import com.epam.framework.enums.DriverType;
import com.epam.hackathon.pages.Youtube;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
public class SampleTest {
    Youtube youtube;
    @Test(alwaysRun = true)
    public void setUp(){

        youtube = new Youtube();
        youtube.launchBrowser("https://www.youtube.com", DriverType.CHROME);
        youtube.search("EPAM Systems Global");
        youtube.chooseFirstElement();
    }


}
