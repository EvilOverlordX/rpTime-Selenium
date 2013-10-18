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
public abstract class Button<T> {

    private WebDriver driver;
    private WebElement element;

    public Button(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.id(elementId));
    }

    public abstract T click();

}
