package com.epam.hackathon.testScripts;

import com.epam.framework.enums.DriverType;
import com.epam.hackathon.pages.Youtube;
import org.testng.annotations.Test;

public class SampleTest {
    Youtube youtube;
    @Test(alwaysRun = true)
    public void setUp(){
        youtube = new Youtube();
        youtube.launchBrowser("https://www.youtube.com/", "EPAM Systems Global", DriverType.CHROME);
        youtube.chooseFirstElement();
        youtube.navigateTOVideos();
        youtube.sortUsingLatest();
        youtube.videos();
    }


}
