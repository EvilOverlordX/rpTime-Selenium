package com.roosterpark.rptime.selenium.control;

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

    public CheckBox(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.id(elementId));
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public WebElement getElement() {
        return element;
    }

    public void check() {
        element.click();
    }

    public boolean isChecked() {
        return element.isSelected();
    }
}
