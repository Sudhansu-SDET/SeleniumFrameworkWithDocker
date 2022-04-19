package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.tmb.driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public final class HomepageTests extends BaseTest {

    private HomepageTests() {
    } // private constructor to avoid extends/object creation


    /*1. validate the title contains 'google search'
    2. validate title is not null
    3. validate length of title is greater than 50 and less 100
    4. check all links and validate presence of testing mini bytes - youtube link
    */

    @Test
    public void test2() throws Throwable {
        getDriver().findElement(By.name("q")).sendKeys("Testing Mini Bytes - YouTube", Keys.ENTER);
        String Title = getDriver().getTitle();
        System.out.println(Title);
        assertThat(Title)
                .isNotNull()
                .as("fail:name mismatch").containsIgnoringCase("google search")
                .hasSizeBetween(10, 50);

        List<WebElement> allLinks = getDriver().findElements(By.xpath("//h3"));
        assertThat(allLinks)
                .extracting(e -> e.getText())
                .contains("Testing Mini Bytes - YouTube");

    }
}
