package com.roosterpark.rptime.selenium.page.popup;

import com.roosterpark.rptime.selenium.page.UserTimeSheetPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 11/21/13
 * Time: 10:48 AM
 */
public class TimeSheetPopup {

    private static final String ID = "dropdown-menu";

    private WebDriver driver;

    public TimeSheetPopup(WebDriver driver) {
        this.driver = driver;
    }

    public void view() {
        WebElement element = driver.findElement(By.className(ID));
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();
    }

    public UserTimeSheetPage clickLastWeekLink() {
        LastWeekLink lastWeekLink = new LastWeekLink(driver);
        return lastWeekLink.click();
    }

    public UserTimeSheetPage clickThisWeekLink() {
        ThisWeekLink thisWeekLink = new ThisWeekLink(driver);
        return thisWeekLink.click();
    }

    public UserTimeSheetPage clickNextWeekLink() {
        NextWeekLink nextWeekLink = new NextWeekLink(driver);
        return nextWeekLink.click();
    }

}
