package com.roosterpark.rptime.selenium.control.complex.list.timesheet;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.control.finder.FindByHelper.ById;
import com.roosterpark.rptime.selenium.page.UserTimeSheetPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 1/7/14
 * Time: 8:49 AM
 */
public class UserTimeSheetRowLink extends Link<UserTimeSheetPage> {

    public UserTimeSheetRowLink(WebDriver driver, String id) {
        super(driver, id, new ById());
    }

    @Override
    public UserTimeSheetPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new UserTimeSheetPage(getDriver());
    }

}
