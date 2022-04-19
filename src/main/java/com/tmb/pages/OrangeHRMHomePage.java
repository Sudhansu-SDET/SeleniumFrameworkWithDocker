package com.tmb.pages;

import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage{
    private final By link_Welcome = By.id("welcome");
    private final By link_Logout = By.xpath("//a[text()='Logout']");


    public OrangeHRMHomePage clickWelcome() throws Exception {
        //getDriver().findElement(link_Welcome).click();
        click(link_Welcome,"Welcome Link");
        return this;
    }

    public OrangeHRMHomePage clickLogOut() throws Exception {
        //getDriver().findElement(link_Logout).click();
        explicitWaitForElementToBeClickable(link_Logout);
        click(link_Logout, "Logout button");
        return this;
    }

}
