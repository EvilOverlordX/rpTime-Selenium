package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.page.UserTimeSheetPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 12/10/13
 * Time: 3:08 PM
 */
public class SubmitButton extends Button<UserTimeSheetPage> {

    private static final String ID = "submit";

    public SubmitButton(WebDriver driver) {
        super(driver, ID);
    }


    @Override
    public UserTimeSheetPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new UserTimeSheetPage(getDriver());
    }
}
