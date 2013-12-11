package com.roosterpark.rptime.selenium.control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:50 PM
 */
public interface Control {

    public WebDriver getDriver();
    public WebElement getElement();
    public By getBy();

}
