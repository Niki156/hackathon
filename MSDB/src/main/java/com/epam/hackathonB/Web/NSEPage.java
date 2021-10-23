package com.epam.hackathonB.Web;

import com.epam.framework.base.TestBase;
import com.epam.framework.enums.DriverType;
import com.epam.framework.utils.WaitUtilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.swing.text.Utilities;

public class NSEPage extends TestBase {

    private WebDriver driver;

    @FindBy(id = "#page-search")
    private WebElement searchInput;

    @FindBy()
    private WebElement sae;

    public WebElement getSearchInput(){
        return searchInput;
    }

    public NSEPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,100),this);
    }

    public void findSearchWith(String text){
        WaitUtilities.waitForElementToBeVisible(driver,30,getSearchInput());
        getSearchInput().sendKeys(text, Keys.ENTER);
    }



}
