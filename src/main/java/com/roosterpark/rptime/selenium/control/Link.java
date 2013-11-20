package com.roosterpark.rptime.selenium.control;

import com.roosterpark.rptime.selenium.control.finder.FindByHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/22/13
 * Time: 2:42 PM
 *
 * An abstract base class for Links
 */
public abstract class Link<T> implements Control {

    private WebDriver driver;
    private WebElement element;

    public Link(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.linkText(elementId));
    }

    public Link(WebDriver driver, String elementId, FindByHelper helper) {
        this.driver = driver;
        this.element = this.driver.findElement(helper.find(elementId));
    }

    public abstract T click();

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getElement() {
        return element;
    }

}
