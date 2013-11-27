package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/27/13
 * Time: 10:30 AM
 */
public class ClientDropDownLink extends Link<Void> {

    private String name;

    public ClientDropDownLink(WebDriver driver, String id) {
        super(driver, id);
        this.name = id;
    }

    @Override
    public Void click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return null;
    }

    public String getName() {
        return name;
    }

}
