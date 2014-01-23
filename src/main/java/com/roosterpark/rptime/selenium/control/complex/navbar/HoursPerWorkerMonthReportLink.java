package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.admin.HoursPerWorkerMonthReportPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/20/13
 * Time: 11:34 AM
 */
public class HoursPerWorkerMonthReportLink extends Link<HoursPerWorkerMonthReportPage> {

    private static final String ID = "Hours per Worker/Month, all Clients";

    public HoursPerWorkerMonthReportLink(WebDriver driver) {
        super(driver, ID);
    }

    @Override
    public HoursPerWorkerMonthReportPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new HoursPerWorkerMonthReportPage(getDriver());
    }
}
