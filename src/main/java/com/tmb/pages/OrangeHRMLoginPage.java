package com.tmb.pages;

import org.openqa.selenium.By;

import static com.tmb.driver.DriverManager.getDriver;

public final class OrangeHRMLoginPage extends BasePage{

    public final By textbox_username = By.xpath("//input[@id='txtUsername']");
    public final By textbox_password = By.xpath("//input[@id='txtPassword' and @type='password']");
    public final By button_login = By.xpath("//input[@id='btnLogin']");

    public OrangeHRMLoginPage enterUserName(String userName) throws Exception {


        sendKeys(textbox_username,userName,"username");
        return this;
    }
    public OrangeHRMLoginPage enterPassword(String password) throws Exception {


        sendKeys(textbox_password,password,"password");
        return this;
    }

    public OrangeHRMLoginPage clickLogin() throws Exception {
        click(button_login,"login button");
        return this; // method chaining

    }



}
