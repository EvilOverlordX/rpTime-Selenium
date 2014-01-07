package com.roosterpark.rptime.selenium.control.complex.list.timesheet.status;

import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 1/7/14
 * Time: 9:56 AM
 */
public class Approved implements Status {

    private WebElement element;

    public Approved(WebElement element) {
        this.element = element;
    }

    @Override
    public boolean isVisible() {
        return element.isDisplayed();
    }

}
