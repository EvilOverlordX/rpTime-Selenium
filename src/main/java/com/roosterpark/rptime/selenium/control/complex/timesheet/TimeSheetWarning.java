package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 1/27/14
 * Time: 10:52 AM
 */
public class TimeSheetWarning {

    private static final String ID = "timeSheetWarning";

    private WebDriver driver;

    public TimeSheetWarning(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isVisible() {
        WebElement element = driver.findElement(By.id(ID));
        return element.isDisplayed();
    }

    public void clickAlertCloseButton() {
        AlertCloseButton alertCloseButton = new AlertCloseButton(driver);
        alertCloseButton.click();
    }

    private class AlertCloseButton extends Button<Void> {

        private static final String BUTTON_ID = "timesheet-alert-close";

        public AlertCloseButton(WebDriver driver) {
            super(driver, BUTTON_ID);
        }

        @Override
        public Void click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return null;
        }
    }

}
