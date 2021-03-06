package com.roosterpark.rptime.selenium.control.complex.navbar.link;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/24/13
 * Time: 10:25 AM
 */
public class HomeLink extends Link<HomePage> {

    private static final String HOME_LINK = "Home";

    public HomeLink(WebDriver driver) {
        super(driver, HOME_LINK);
    }

    @Override
    public HomePage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new HomePage(getDriver());
    }
}
