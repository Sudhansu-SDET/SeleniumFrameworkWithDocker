package com.tmb.tests;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static com.tmb.driver.DriverManager.getDriver;

public final class HomepageTests extends BaseTest{

    private HomepageTests(){} // private constructor to avoid extends/object creation


    /*1. validate the title contains 'google search'
    2. validate title is not null
    3. validate length of title is greater than 50 and less 100
    4. check all links and validate presence of testing mini bytes - youtube link

     */
    @Test
    public void test2() throws Throwable {
        getDriver().findElement(By.name("q")).sendKeys("testing mini bytes - youtube", Keys.ENTER);
        String Title = getDriver().getTitle();
        Assert.assertTrue(Objects.nonNull(Title),"Title is null");
        Assert.assertTrue(Title.toLowerCase().contains("google search"));
        Assert.assertTrue(Title.length()>10);
        Assert.assertTrue(Title.length()<50);
        List<WebElement> allLinks = getDriver().findElements(By.xpath("//h3"));

        boolean isElementPresent = false;
        for(WebElement eachLink : allLinks){
                if(eachLink.getText().equalsIgnoreCase("testing mini bytes - youtube")){
                    isElementPresent = true;
                    break;
                }
        }
        Assert.assertTrue(isElementPresent,"The text is not found in google search");
    }
}
