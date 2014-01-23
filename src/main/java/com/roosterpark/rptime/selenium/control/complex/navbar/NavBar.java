package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.complex.navbar.link.UserTimeSheetsLink;
import com.roosterpark.rptime.selenium.page.UserTimeSheetPage;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/23/13
 * Time: 1:22 PM
 */
public class NavBar {

    private WebDriver driver;
    private UserTimeSheetsLink userTimeSheetsLink;

    public NavBar(WebDriver driver) {
        this.driver = driver;
        userTimeSheetsLink = new UserTimeSheetsLink(driver);
    }

    public UserTimeSheetPage clickTimeSheetsLink() {
        return userTimeSheetsLink.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
