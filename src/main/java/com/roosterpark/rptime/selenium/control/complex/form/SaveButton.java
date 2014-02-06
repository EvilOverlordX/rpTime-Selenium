package com.roosterpark.rptime.selenium.control.complex.form;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.timer.WaitForPresent;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/13/13
 * Time: 11:18 AM
 */
public class SaveButton extends Button<Void> {

    private static final String SAVE_ID = "save";

    public SaveButton(WebDriver driver) {
        super(driver, SAVE_ID);
    }

    @Override
    public Void click() {
        WaitForPresent waitForPresent = new WaitForPresent(getDriver());
        waitForPresent.defaultWaitForPresent(getBy());
        //WaitForVisible waitForVisible = new WaitForVisible(getElement());
        //waitForVisible.defaultWaitForVisible();
        getElement().click();
        return null;
    }

}
