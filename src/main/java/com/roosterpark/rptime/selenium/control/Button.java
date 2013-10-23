package com.roosterpark.rptime.selenium.control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/18/13
 * Time: 10:03 AM
 *
 * An abstract base class for Button controls
 */
public abstract class Button<T> implements Control {

    private WebDriver driver;
    private WebElement element;

    public Button(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.id(elementId));
    }

    public Button(WebDriver driver, String elementId, boolean isByName) {
        this.driver = driver;
        if (isByName) {
            this.element = this.driver.findElement(By.name(elementId));
        } else {
            this.element = this.driver.findElement(By.id(elementId));
        }
    }

    public abstract T click();

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getElement() {
        return element;
    }

}
