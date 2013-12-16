package com.roosterpark.rptime.selenium;

import com.roosterpark.rptime.selenium.control.complex.navbar.NavBar;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 12/16/13
 * Time: 10:33 AM
 */
public abstract class StandardPageObject extends BasicPageObject {

    public StandardPageObject(WebDriver driver) {
        super(driver);
    }

    public NavBar getNavBar() {
        return new NavBar(getWebDriver());
    }

}
