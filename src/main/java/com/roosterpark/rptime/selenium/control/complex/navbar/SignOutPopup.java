package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 12/5/13
 * Time: 3:24 PM
 */
public class SignOutPopup {

    private SignOutLink signOutLink;
    private WebDriver driver;

    public SignOutPopup(WebDriver driver) {
        signOutLink = new SignOutLink(driver);
        this.driver = driver;
    }

    public void clickSignOutLink() {
        signOutLink.click();
    }

    public void view() {
        WebElement element = driver.findElement(By.className("dropdown-menu"));
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();
    }

    private class SignOutLink extends Link<Void> {

        private static final String ID = "Sign out";

        public SignOutLink(WebDriver driver) {
            super(driver, ID);
        }

        @Override
        public Void click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return null;
        }
    }

}
