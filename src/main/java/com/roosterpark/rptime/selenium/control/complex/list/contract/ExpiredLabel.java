package com.roosterpark.rptime.selenium.control.complex.list.contract;

import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 1/13/14
 * Time: 3:36 PM
 */
public class ExpiredLabel {

    private WebElement element;

    public ExpiredLabel(WebElement element) {
        this.element = element;
    }

    public boolean isVisible() {
        return element.isDisplayed();
    }

}
