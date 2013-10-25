package com.roosterpark.rptime.selenium;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:15 PM
 */
public abstract class BasicSeleniumTest {

    private WebDriver driver;

    @Before
    public void initializeWebDriver() {
        driver = new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
