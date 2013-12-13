package com.roosterpark.rptime.selenium.page.popup;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.control.finder.FindByHelper.ById;
import com.roosterpark.rptime.selenium.page.UserTimeSheetPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/21/13
 * Time: 11:33 AM
 */
public class NextWeekLink extends Link<UserTimeSheetPage> {

    private static final String ID = "set-week-next";

    public NextWeekLink(WebDriver driver) {
        super(driver, ID, new ById());
    }

    @Override
    public UserTimeSheetPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new UserTimeSheetPage(getDriver());
    }
}
