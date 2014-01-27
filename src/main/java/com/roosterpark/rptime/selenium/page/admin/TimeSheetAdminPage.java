package com.roosterpark.rptime.selenium.page.admin;

import com.roosterpark.rptime.selenium.AdminPageObject;
import com.roosterpark.rptime.selenium.control.complex.timesheet.TimeSheetWarning;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

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

}
