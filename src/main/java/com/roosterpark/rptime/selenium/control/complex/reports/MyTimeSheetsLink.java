package com.roosterpark.rptime.selenium.control.complex.reports;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.control.finder.FindByHelper.ById;
import com.roosterpark.rptime.selenium.page.admin.MyTimeSheetsPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 1/21/14
 * Time: 2:33 PM
 */
public class MyTimeSheetsLink extends Link<MyTimeSheetsPage> {

    public MyTimeSheetsLink(WebDriver driver, String id) {
        super(driver, id, new ById());
    }

    @Override
    public MyTimeSheetsPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new MyTimeSheetsPage(getDriver());
    }


}
