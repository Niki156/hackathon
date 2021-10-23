package com.epam.hackathon.testScripts;

import com.epam.framework.base.TestBase;
import com.epam.framework.enums.DriverType;
import com.epam.framework.utils.ScreenShotTaker;
import com.epam.framework.utils.WaitUtilities;
import com.epam.hackathon.pages.Youtube;
import com.epam.hackathon.utils.HelperFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class SampleTest extends TestBase {
    Youtube youtube;
    @Test(alwaysRun = true)
    public void setUp(){
        driver = launchBrowser("https://www.youtube.com/",DriverType.CHROME);
        youtube = new Youtube(driver);
        youtube.openUrlAndfindSearchWith("https://www.youtube.com/", "EPAM Systems Global",driver);
        youtube.chooseFirstElement();
        youtube.navigateTOVideos();
        youtube.sortUsingLatest();
        List<WebElement> list = youtube.getvideoTitlesWithInOneYear();
        int index = HelperFunctions.getRandomEvenNumbersFromFibonaciiSeries(9);
        System.out.println(list.get(index).getText());
        list.get(index).click();
        ScreenShotTaker.takeScreenShot(driver,"Uiss");
        WaitUtilities.threadWait(20000);
        driver.navigate().back();
        List<WebElement> list1 = youtube.getvideoTitlesWithInOneYear();

        String title = HelperFunctions.getVideoTitleFromApi("https://testathon-service.herokuapp.com/api/videos/title");
        for(WebElement e :list1)
            if(e.getText().contains(title))
            {
                e.click();
            }
        ScreenShotTaker.takeScreenShot(driver,"apiss");
        WaitUtilities.threadWait(10000);
    }

}
