package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:33 PM
 */
public class RpTimePage extends BasicPageObject {

    private TimeSheetLink timeSheetLink;
    private HistoryLink historyLink;
    private ReportLink reportLink;

    public RpTimePage(WebDriver driver) {
        super(driver);
    }

    public TimeSheetPage clickTimeSheetLink() {
        timeSheetLink = new TimeSheetLink(getWebDriver());
        return timeSheetLink.click();
    }

    public HistoryPage clickHistoryLink() {
        historyLink = new HistoryLink(getWebDriver());
        return historyLink.click();
    }

    public ReportPage clickReportsLink() {
        reportLink = new ReportLink(getWebDriver());
        return reportLink.click();
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("RpTime page should not be opened directly.");
    }

    private class TimeSheetLink extends Link<TimeSheetPage> {

        private static final String TIME_SHEET_LINK = "Current Time Sheet";

        public TimeSheetLink(WebDriver driver) {
            super(driver, TIME_SHEET_LINK);
        }

        @Override
        public TimeSheetPage click() {
            getElement().click();
            return new TimeSheetPage(getDriver());
        }
    }

    private class HistoryLink extends Link<HistoryPage> {

        private static final String HISTORY_LINK = "History";

        public HistoryLink(WebDriver driver) {
            super(driver, HISTORY_LINK);
        }

        @Override
        public HistoryPage click() {
            getElement().click();
            return new HistoryPage(getDriver());
        }
    }

    private class ReportLink extends Link<ReportPage> {

        private static final String REPORT_LINK = "Reports";

        public ReportLink(WebDriver driver) {
            super(driver, REPORT_LINK);
        }

        @Override
        public ReportPage click() {
            getElement().click();
            return new ReportPage(getDriver());
        }
    }

}
