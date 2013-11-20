package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.control.finder.FindByHelper.ByClass;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/20/13
 * Time: 3:00 PM
 */
public class ReportDropDown extends Link<ReportsPopup> {

    private static final String ID = "dropdown-toggle";

    public ReportDropDown(WebDriver driver) {
        super(driver, ID, new ByClass());
    }

    @Override
    public ReportsPopup click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new ReportsPopup(getDriver());
    }
}
