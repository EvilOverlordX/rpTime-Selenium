package com.roosterpark.rptime.selenium.control.complex.list;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/6/13
 * Time: 11:16 AM
 */
public class EditButton extends Button<Void> {

    private WaitForVisible waitForVisible;

    public EditButton(WebDriver driver, String elementId) {
        super(driver, elementId);
    }

    @Override
    public Void click() {
        waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return null;
    }
}
