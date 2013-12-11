package com.roosterpark.rptime.selenium.control;

import com.roosterpark.rptime.selenium.control.finder.FindByHelper;
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
    private By by;

    public Button(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.id(elementId));
        this.by = By.id(elementId);
    }

    public Button(WebDriver driver, String elementId, FindByHelper helper) {
        this.driver = driver;
        this.element = this.driver.findElement(helper.find(elementId));
        this.by = helper.find(elementId);
    }

    public abstract T click();

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

}
