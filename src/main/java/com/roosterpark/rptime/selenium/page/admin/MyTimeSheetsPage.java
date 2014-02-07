package com.roosterpark.rptime.selenium.page.admin;

import com.roosterpark.rptime.selenium.AdminPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 1/21/14
 * Time: 2:04 PM
 */
public class MyTimeSheetsPage extends AdminPageObject {

    public MyTimeSheetsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("My Time sheet page should not be opened directly.");
    }

    public boolean isMyTimeSheetsPage() {
        WebElement timeSheetsDiv = getWebDriver().findElement(By.id("timesheets"));
        WaitForVisible waitForVisible = new WaitForVisible(timeSheetsDiv);
        waitForVisible.defaultWaitForVisible();
        return timeSheetsDiv.isDisplayed();
    }

}
