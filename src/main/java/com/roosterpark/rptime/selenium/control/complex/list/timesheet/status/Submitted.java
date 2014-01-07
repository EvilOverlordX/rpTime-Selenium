package com.roosterpark.rptime.selenium.control.complex.list.timesheet.status;

import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 1/7/14
 * Time: 9:50 AM
 */
public class Submitted implements Status {

    private WebElement element;

    public Submitted(WebElement element) {
        this.element = element;
    }

    @Override
    public boolean isVisible() {
        return element.isDisplayed();
    }

}
