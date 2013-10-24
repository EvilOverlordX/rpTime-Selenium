package com.roosterpark.rptime.selenium.control.complex;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.TimeSheetPage;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/24/13
 * Time: 10:34 AM
 */
public class TimeSheetsLink extends Link<TimeSheetPage> {

    private static final String TIME_SHEETS_LINK = "Timesheets";

    public TimeSheetsLink(WebDriver driver) {
        super(driver, TIME_SHEETS_LINK);
    }

    @Override
    public TimeSheetPage click() {
        getElement().click();
        return new TimeSheetPage(getDriver());
    }
}
