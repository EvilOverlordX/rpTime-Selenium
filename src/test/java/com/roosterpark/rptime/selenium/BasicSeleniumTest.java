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

    private static final String USERNAME = "testuser@roosterpark.com";
    private static final String PASSWORD = "testuser";

    private WebDriver driver;

    @Before
    public void initializeWebDriver() {
        driver = new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUsername() {
        return USERNAME;
    }

    public String getPassword() {
        return PASSWORD;
    }

}
