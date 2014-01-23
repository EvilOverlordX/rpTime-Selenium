package com.roosterpark.rptime.selenium.control.complex.timesheet.button;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.page.UserTimeSheetPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 1/10/14
 * Time: 1:59 PM
 */
public class UpdateButton extends Button<UserTimeSheetPage> {

    private static final String ID = "save";

    public UpdateButton(WebDriver driver) {
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
