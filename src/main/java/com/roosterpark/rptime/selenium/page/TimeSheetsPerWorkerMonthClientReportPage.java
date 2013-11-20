package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/20/13
 * Time: 11:51 AM
 */
public class TimeSheetsPerWorkerMonthClientReportPage extends BasicPageObject {

    public TimeSheetsPerWorkerMonthClientReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Time Sheets per Worker/Month/Client Report page should not"
                                               + " be opened directly.");
    }

}
