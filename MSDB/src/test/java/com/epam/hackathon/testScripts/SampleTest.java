package com.epam.hackathon.testScripts;

import com.epam.framework.base.TestBase;
import com.epam.framework.enums.DriverType;
import com.epam.hackathon.pages.Youtube;
import org.testng.annotations.Test;

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
        youtube.videoTitles();
        youtube.videos();


    }


}
