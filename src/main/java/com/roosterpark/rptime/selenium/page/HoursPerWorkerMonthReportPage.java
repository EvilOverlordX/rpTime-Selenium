package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/20/13
 * Time: 11:34 AM
 */
public class HoursPerWorkerMonthReportPage extends BasicPageObject {

    public HoursPerWorkerMonthReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Hours per Worker/Month Report page should not be opened directly.");
    }

}
