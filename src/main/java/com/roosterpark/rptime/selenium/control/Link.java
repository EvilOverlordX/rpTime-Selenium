package com.roosterpark.rptime.selenium.control;

import com.roosterpark.rptime.selenium.control.finder.FindByHelper;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
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
    private By by;

    public Link(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.linkText(elementId));
        this.by = By.linkText(elementId);
    }

    public Link(WebDriver driver, String elementId, FindByHelper helper) {
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

    public String getLinkText() {
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();
        return getElement().getText();
    }

}
