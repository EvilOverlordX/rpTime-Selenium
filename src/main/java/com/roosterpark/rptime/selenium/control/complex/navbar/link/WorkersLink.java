package com.roosterpark.rptime.selenium.control.complex.navbar.link;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.admin.WorkerPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/24/13
 * Time: 11:01 AM
 */
public class WorkersLink extends Link<WorkerPage> {

    private static final String WORKERS_LINK = "Workers";

    public WorkersLink(WebDriver driver) {
        super(driver, WORKERS_LINK);
    }

    @Override
    public WorkerPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new WorkerPage(getDriver());
    }
}
