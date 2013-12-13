package com.roosterpark.rptime.selenium.control;

import com.roosterpark.rptime.selenium.timer.WaitForPresent;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/29/13
 * Time: 11:16 AM
 */
public class CheckBox implements Control {

    private WebDriver driver;
    private WebElement element;
    private By by;

    public CheckBox(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.id(elementId));
        this.by = By.id(elementId);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public WebElement getElement() {
        return element;
    }

    @Override
    public By getBy() {
        return by;
    }

    public void check() {
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();
        element.click();
    }

    public boolean isChecked() {
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();
        return element.isSelected();
    }
}
