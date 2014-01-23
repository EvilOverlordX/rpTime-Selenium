package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 1/23/14
 * Time: 10:48 AM
 */
public class PrintButton extends Button<Void> {

    private static final String ID = "print";

    public PrintButton(WebDriver driver) {
        super(driver, ID);
    }

    @Override
    public Void click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return null;
    }
}
