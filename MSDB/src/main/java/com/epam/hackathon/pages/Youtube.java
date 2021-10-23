package com.epam.hackathon.pages;

import com.epam.framework.base.TestBase;
import com.epam.framework.utils.WaitUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Youtube extends TestBase {
    @FindBy(css = "div#search-container")
    private WebElement searchInput;

    @FindBy(css = "button#search-icon-legacy")
    private WebElement searchButton;

    @FindBy(css = "div#container div#text-container yt-formatted-string#text")
    private List<WebElement> listOfChannelNames;

    public WebElement getSearchInputElement(){
        return searchInput;
    }

    public WebElement getSearchButtonElement(){
        WaitUtilities.waitForElementToBeVisible(driver, 10, searchButton);
        return searchButton;
    }


    public void search(String searchTerm){
        WaitUtilities.waitForElementToBeClickable(driver, 10, driver.findElement(By.id("search")));
        driver.findElement(By.id("search")).sendKeys("Happiness");
        getSearchInputElement().click();
        getSearchInputElement().sendKeys(searchTerm);
        getSearchButtonElement().click();
    }

    public void chooseFirstElement(){
        WaitUtilities.waitForElementToBeVisible(driver, 10, listOfChannelNames.get(0));
        listOfChannelNames.get(0).click();
    }



}
