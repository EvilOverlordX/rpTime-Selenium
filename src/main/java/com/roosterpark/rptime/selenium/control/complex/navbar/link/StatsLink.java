package com.roosterpark.rptime.selenium.control.complex.navbar.link;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.admin.StatsPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 1/27/14
 * Time: 2:21 PM
 */
public class StatsLink extends Link<StatsPage> {

    private static final String STATS_ID = "Stats";

    public StatsLink(WebDriver driver) {
        super(driver, STATS_ID);
    }

    @Override
    public StatsPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new StatsPage(getDriver());
    }
}
