package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.MyTimeSheetsPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 1/23/14
 * Time: 9:22 AM
 */
public class MyTimeSheetsLink extends Link<MyTimeSheetsPage> {

    private static final String MY_TIME_SHEETS_LINK = "My Time Sheets";

    public MyTimeSheetsLink(WebDriver driver) {
        super(driver, MY_TIME_SHEETS_LINK);
    }

    @Override
    public MyTimeSheetsPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new MyTimeSheetsPage(getDriver());
    }

}
