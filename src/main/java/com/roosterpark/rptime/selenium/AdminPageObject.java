package com.roosterpark.rptime.selenium;

import com.roosterpark.rptime.selenium.control.AdminWarning;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 12/16/13
 * Time: 10:26 AM
 */
public abstract class AdminPageObject extends BasicPageObject {

    public AdminPageObject(WebDriver driver) {
        super(driver);
    }

    public AdminNavBar getNavBar() {
        return new AdminNavBar(getWebDriver());
    }

    public boolean isAdminWarningVisible() {
        AdminWarning adminWarning = new AdminWarning(getWebDriver());
        return adminWarning.isAdminWarningDisplayed();
    }

}
