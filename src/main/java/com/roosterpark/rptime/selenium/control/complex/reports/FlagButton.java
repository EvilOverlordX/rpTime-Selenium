package com.roosterpark.rptime.selenium.control.complex.reports;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 1/21/14
 * Time: 3:07 PM
 */
public class FlagButton extends Button<Void> {

    public FlagButton(WebDriver driver, String id) {
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
