package com.roosterpark.rptime.selenium.control;

import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * User: John
 * Date: 10/30/13
 * Time: 2:52 PM
 */
public abstract class DropDownList implements Control {

    private WebDriver driver;
    private WebElement element;
    private Select select;
    private By by;

    public DropDownList(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.id(elementId));
        this.by = By.id(elementId);
        this.select = new Select(this.element);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getElement() {
        return element;
    }

    public Select getSelect() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        return select;
    }

    public By getBy() {
        return by;
    }

}
