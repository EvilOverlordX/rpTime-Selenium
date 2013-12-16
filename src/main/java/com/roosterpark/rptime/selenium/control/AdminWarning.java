package com.roosterpark.rptime.selenium.control;

import com.roosterpark.rptime.selenium.timer.WaitForPresent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 12/16/13
 * Time: 10:14 AM
 */
public class AdminWarning {

    private static final String ID = "adminWarning";

    private WebDriver driver;

    public AdminWarning(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAdminWarningDisplayed() {
        WaitForPresent waitForPresent = new WaitForPresent(driver);
        waitForPresent.defaultWaitForPresent(By.id(ID));
        WebElement element = driver.findElement(By.id(ID));
        return element.isDisplayed();
    }

}
