package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/20/13
 * Time: 11:51 AM
 */
public class TimeSheetsPerWorkerMonthClientReportPage extends BasicPageObject {

    private static final String PREVIOUS_BUTTON_ID = "previousMonth";
    private static final String NEXT_BUTTON_ID = "nextMonth";

    public TimeSheetsPerWorkerMonthClientReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Time Sheets per Worker/Month/Client Report page should not"
                                               + " be opened directly.");
    }

    public TimeSheetsPerWorkerMonthClientReportPage clickPreviousMonthButton() {
        PreviousMonthButton previousMonthButton = new PreviousMonthButton();
        return previousMonthButton.click();
    }

    public TimeSheetsPerWorkerMonthClientReportPage clickNextMonthButton() {
        NextMonthButton nextMonthButton = new NextMonthButton();
        return nextMonthButton.click();
    }

    private class PreviousMonthButton extends Button<TimeSheetsPerWorkerMonthClientReportPage> {

        public PreviousMonthButton() {
            super(getWebDriver(), PREVIOUS_BUTTON_ID);
        }

        @Override
        public TimeSheetsPerWorkerMonthClientReportPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new TimeSheetsPerWorkerMonthClientReportPage(getDriver());
        }

    }

    private class NextMonthButton extends Button<TimeSheetsPerWorkerMonthClientReportPage> {

        public NextMonthButton() {
            super(getWebDriver(), NEXT_BUTTON_ID);
        }

        @Override
        public TimeSheetsPerWorkerMonthClientReportPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new TimeSheetsPerWorkerMonthClientReportPage(getDriver());
        }

    }

}
