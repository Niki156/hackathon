package com.epam.hackathon.pages;

import com.epam.framework.base.TestBase;
import com.epam.framework.enums.DriverType;
import com.epam.framework.utils.WaitUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class Youtube extends TestBase {


    @FindBy(css = "div#icon-label")
    WebElement sort;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchInput;

    @FindBy(css = "button#search-icon-legacy")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"tabsContent\"]/tp-yt-paper-tab[2]/div")
    private WebElement videosButton;

    @FindBy(xpath = "//*[@id=\"menu\"]/a[3]/tp-yt-paper-item/tp-yt-paper-item-body/div[1]")
    private WebElement latestSortOption;

    @FindBy(css = "div#items ytd-grid-video-renderer")
    private List<WebElement> videos;

    @FindBy(xpath = "//*[@id='video-title']")
    private List<WebElement> videoTitle;


    private By contents = By.cssSelector("div#container div#text-container yt-formatted-string#text");

    public Youtube(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,100),this);
    }
    public List<WebElement> getvideoTitles() {
        WaitUtilities.threadWait(10000);
        return videoTitle;
    }

    public WebElement getSearchInputElement() {
        return searchInput;
    }

    public void openUrlAndfindSearchWith(String url,String searchTerm,WebDriver driver) {
        String finalUrl = url + "results?search_query=" + searchTerm.replace(" ", "+");
       openUrl(finalUrl,driver);
    }


    public WebElement getSearchButtonElement() {
        WaitUtilities.waitForElementToBeVisible(driver, 10, searchButton);
        return searchButton;
    }


    public void search(String searchTerm) {

        getSearchInputElement().click();
        getSearchInputElement().sendKeys(searchTerm);
        getSearchButtonElement().click();
    }

    public void chooseFirstElement() {
        WaitUtilities.threadWait(5000);
        List<WebElement> content = driver.findElements(contents);
        content.get(0).click();
    }

    public void navigateTOVideos() {
        String url = driver.getCurrentUrl();
        driver.get(url + "/videos");
    }

    public void sortUsingLatest() {
        driver.get(driver.getCurrentUrl() + "/?view=0&sort=dd&flow=grid");
    }

    public List<String> videoTitles() {
        System.out.println(getvideoTitles());
        List<WebElement> list = getvideoTitles();
        for (WebElement ele : list)
        {
            HashMap<String,String> hashMap = new HashMap<String,String>();
        }
        return null;
    }


}
