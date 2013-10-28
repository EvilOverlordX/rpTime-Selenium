package com.roosterpark.rptime.selenium;

import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.control.complex.navbar.NavBar;
import com.roosterpark.rptime.selenium.exception.NavBarException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/24/13
 * Time: 1:45 PM
 */
public abstract class NavBarPageObject extends BasicPageObject {

    private boolean adminSet;

    public NavBarPageObject(WebDriver driver) {
        super(driver);
        adminSet = false;
    }

    public boolean isAdminSet() {
        return adminSet;
    }

    public void setAdmin(boolean isAdmin) {
        adminSet = isAdmin;
    }

    public AdminNavBar getAdminNavBar() {
        if (!adminSet) {
            throw new NavBarException("Admin nav bar should only be accessed when an Admin user is logged in.");
        } else {
            return new AdminNavBar(getWebDriver());
        }
    }

    public NavBar getNavBar() {
        if (adminSet) {
            throw new NavBarException("Standard nav bar should only be accessed when a non-admin user is logged in");
        } else {
            return new NavBar(getWebDriver());
        }
    }

    public boolean isLoggedInAsAdmin() {
        WebElement element = getWebDriver().findElement(By.id("rpTimeWrapperDiv"));
        String attributeValue = element.getAttribute("ng-controller");
        return attributeValue.equals("AdminPageCtrl");
    }

}
