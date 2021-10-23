package com.epam.framework.utils;

import com.epam.framework.loggers.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public  class WaitUtilities {

    private WaitUtilities(){}

    public static void waitForElementToBeClickableAndClick(WebDriver driver, final WebElement element,long timeOutInsec) {
       waitForElementToBeClickable(driver,timeOutInsec,element).click();
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver,long timeOutInsec,final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInsec);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static WebElement waitForElementToBeVisible(WebDriver driver,long timeOutInsec,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInsec);
        return wait.until(visibilityOf(element));
    }

    public static void waitForElementToBeVisibleAndSendKeys(WebDriver driver,long timeOutInsec,WebElement element, String keys) {
      WebElement foundElement = waitForElementToBeVisible(driver,timeOutInsec,element);
      foundElement.clear();
      foundElement.sendKeys(keys);
    }

    public static void waitForElementToBeVisibleAndClick(WebDriver driver,WebElement element,long timeOutInsec){
        waitForElementToBeVisible(driver,timeOutInsec,element).click();
    }

    public static void waitForElementToBePresented(WebDriver driver, By locator,long timeOutInsec){
        new WebDriverWait(driver, timeOutInsec)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void threadWait(long millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            Log.logInfo(e);
            Thread.currentThread().interrupt();
        }
    }
}