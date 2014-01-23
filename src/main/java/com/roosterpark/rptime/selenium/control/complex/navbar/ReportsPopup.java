package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.page.admin.HoursPerWorkerMonthReportPage;
import com.roosterpark.rptime.selenium.page.admin.TimeSheetsPerWorkerMonthClientReportPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 11/20/13
 * Time: 3:01 PM
 */
public class ReportsPopup {

    private static final String ID = "dropdown-menu";

    private WebDriver driver;

    public ReportsPopup(WebDriver driver) {
        this.driver = driver;
    }

    public void view() {
        WebElement element = driver.findElement(By.className(ID));
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();
    }

    public HoursPerWorkerMonthReportPage clickHoursPerWorkerMonthReportLink() {
        HoursPerWorkerMonthReportLink link = new HoursPerWorkerMonthReportLink(driver);
        return link.click();
    }

    public TimeSheetsPerWorkerMonthClientReportPage clickTimeSheetsPerWorkerMonthClientReportLink() {
        TimeSheetsPerWorkerMonthClientReportLink link = new TimeSheetsPerWorkerMonthClientReportLink(driver);
        return link.click();
    }

}
