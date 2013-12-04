package com.roosterpark.rptime.selenium.control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/23/13
 * Time: 10:26 AM
 */
public class TextField implements Control {

    private WebDriver driver;
    private WebElement element;

    public TextField(WebDriver driver, String elementId) {
        this.driver = driver;
        this.element = this.driver.findElement(By.id(elementId));
    }

    public void clear() {
        element.clear();
    }

    public void enterText(String text) {
        element.sendKeys(text);
    }

    public String getText() {
        return element.getText();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public WebElement getElement() {
        return element;
    }
}
