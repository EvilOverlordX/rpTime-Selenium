package com.roosterpark.rptime.selenium.page.admin;

import com.roosterpark.rptime.selenium.AdminPageObject;
import com.roosterpark.rptime.selenium.control.complex.timesheet.TimeSheetWarning;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:07 PM
 */
public class TimeSheetAdminPage extends AdminPageObject {

    public TimeSheetAdminPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Time sheet page should not be opened directly.");
    }

    public boolean isTimeSheetWarningVisible() {
        TimeSheetWarning timeSheetWarning = new TimeSheetWarning(getWebDriver());
        return timeSheetWarning.isVisible();
    }

    public void clickTimeSheetAlertCloseButton() {
        TimeSheetWarning timeSheetWarning = new TimeSheetWarning(getWebDriver());
        timeSheetWarning.clickAlertCloseButton();
    }

    public boolean isTimeSheetsAdminPage() {
        WebElement timeSheetsDiv = getWebDriver().findElement(By.id("timesheets"));
        WaitForVisible waitForVisible = new WaitForVisible(timeSheetsDiv);
        waitForVisible.defaultWaitForVisible();
        return timeSheetsDiv.isDisplayed();
    }

}
