package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/27/13
 * Time: 1:11 PM
 */
public class RemoveButton extends Button<Void> {

    public RemoveButton(WebDriver driver, String id) {
        super(driver, id);
    }

    @Override
    public Void click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return null;
    }

}
