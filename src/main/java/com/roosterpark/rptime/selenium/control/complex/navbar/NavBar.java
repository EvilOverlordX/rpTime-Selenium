package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.TimeSheetPage;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/23/13
 * Time: 1:22 PM
 */
public class NavBar {

    private WebDriver driver;
    private HomeLink homeLink;
    private TimeSheetsLink timeSheetsLink;

    public NavBar(WebDriver driver) {
        this.driver = driver;
        homeLink = new HomeLink(driver);
        timeSheetsLink = new TimeSheetsLink(driver);
    }

    public HomePage clickHomeLink() {
        return homeLink.click();
    }

    public TimeSheetPage clickTimeSheetsLink() {
        return timeSheetsLink.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
