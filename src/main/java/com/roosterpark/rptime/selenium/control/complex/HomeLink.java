package com.roosterpark.rptime.selenium.control.complex;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.HomePage;
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
        getElement().click();
        return new HomePage(getDriver());
    }
}
