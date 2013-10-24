package com.roosterpark.rptime.selenium.control.complex;

import com.roosterpark.rptime.selenium.page.HistoryPage;
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
    private HistoryLink historyLink;
    private HomeLink homeLink;
    private TimeSheetsLink timeSheetsLink;

    public NavBar(WebDriver driver) {
        this.driver = driver;
        historyLink = new HistoryLink(driver);
        homeLink = new HomeLink(driver);
        timeSheetsLink = new TimeSheetsLink(driver);
    }

    public HistoryPage clickHistoryLink() {
        return historyLink.click();
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
