package com.roosterpark.rptime.selenium.page.admin;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.control.complex.reports.TotalHoursReportTable;
import com.roosterpark.rptime.selenium.control.reports.ReportDate;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 11/20/13
 * Time: 11:34 AM
 */
public class HoursPerWorkerMonthReportPage extends BasicPageObject {

    private static final String PREVIOUS_BUTTON_ID = "previousMonth";
    private static final String NEXT_BUTTON_ID = "nextMonth";
    private static final String MONTH_YEAR_ID = "monthYear";

    private TotalHoursReportTable totalHoursReportTable;

    public HoursPerWorkerMonthReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Hours per Worker/Month Report page should not be opened directly.");
    }

    public HoursPerWorkerMonthReportPage clickPreviousMonthButton() {
        PreviousMonthButton previousMonthButton = new PreviousMonthButton();
        return previousMonthButton.click();
    }

    public HoursPerWorkerMonthReportPage clickNextMonthButton() {
        NextMonthButton nextMonthButton = new NextMonthButton();
        return nextMonthButton.click();
    }

    public ReportDate getReportDate() {
        WebElement element = getWebDriver().findElement(By.id(MONTH_YEAR_ID));
        return ReportDate.getReportDateFromElement(element);
    }

    public void initializeTotalHoursReportTable() {
        totalHoursReportTable = new TotalHoursReportTable(getWebDriver());
        totalHoursReportTable.initialize();
    }

    public TotalHoursReportTable getTotalHoursReportTable() {
        return totalHoursReportTable;
    }

    public boolean isHoursPerWorkerMonthReportPage() {
        WebElement reportDiv = getWebDriver().findElement(By.id("total-hours-per-worker-per-month"));
        WaitForVisible waitForVisible = new WaitForVisible(reportDiv);
        waitForVisible.defaultWaitForVisible();
        return reportDiv.isDisplayed();
    }

    private class PreviousMonthButton extends Button<HoursPerWorkerMonthReportPage> {

        public PreviousMonthButton() {
            super(getWebDriver(), PREVIOUS_BUTTON_ID);
        }

        @Override
        public HoursPerWorkerMonthReportPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new HoursPerWorkerMonthReportPage(getDriver());
        }

    }

    private class NextMonthButton extends Button<HoursPerWorkerMonthReportPage> {

        public NextMonthButton() {
            super(getWebDriver(), NEXT_BUTTON_ID);
        }

        @Override
        public HoursPerWorkerMonthReportPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new HoursPerWorkerMonthReportPage(getDriver());
        }

    }

}
