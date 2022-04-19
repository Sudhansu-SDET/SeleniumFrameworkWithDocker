package com.tmb.pages;

import com.tmb.constants.FrameworkConstants;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.tmb.driver.DriverManager.getDriver;

public class BasePage {
    protected void click(By by,String elementName) throws Exception {
        getDriver().findElement(by).click();
        ExtentLogger.pass(elementName + " is clicked",true);
    }
    protected void sendKeys(By by,String aValue, String elementName) throws Exception {
        getDriver().findElement(by).sendKeys(aValue);
        ExtentLogger.pass(aValue + " is entered successfully in " + elementName,true);
    }
    protected String getPageTitle(){

        return getDriver().getTitle();
    }

    protected void explicitWaitForElementToBeClickable(By by){
        new WebDriverWait(getDriver(), FrameworkConstants.getEXPLICITWAIT()).until(ExpectedConditions.elementToBeClickable(by));

    }
}
