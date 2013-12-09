package com.roosterpark.rptime.selenium;

import com.roosterpark.rptime.selenium.control.complex.navbar.SignOutButton;
import com.roosterpark.rptime.selenium.control.complex.navbar.SignOutPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/18/13
 * Time: 9:44 AM
 *
 * An abstract base class for Page Object classes
 */
public abstract class BasicPageObject {

    private WebDriver driver;

    public BasicPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public abstract void openPage();

    public void close() {
        driver.quit();
    }

    public void clickSignOutButton(String email) {
        SignOutButton signOutButton = new SignOutButton(getWebDriver(), email);
        SignOutPopup signOutPopup = signOutButton.click();
        signOutPopup.clickSignOutLink();
    }

}
