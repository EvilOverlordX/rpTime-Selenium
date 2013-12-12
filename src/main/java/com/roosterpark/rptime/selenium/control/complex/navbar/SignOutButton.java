package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 12/5/13
 * Time: 3:24 PM
 */
public class SignOutButton extends Button<SignOutPopup> {

    private static final String ID = "signOut";

    private WebDriver driver;

    public SignOutButton(WebDriver driver) {
        super(driver, ID);
        this.driver = driver;
    }

    @Override
    public SignOutPopup click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new SignOutPopup(driver);
    }

}
