package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/22/13
 * Time: 1:24 PM
 */
public class LandingPage extends BasicPageObject {

    private static final String ADDRESS = "http://roosterparktime.appspot.com";

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        getWebDriver().get(ADDRESS);
    }

}
