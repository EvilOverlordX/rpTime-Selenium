package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 12/5/13
 * Time: 3:24 PM
 */
public class SignOutButton extends Link<SignOutPopup> {

    private WebDriver driver;
    private WebElement popupElement;

    public SignOutButton(WebDriver driver, String id) {
        super(driver, id);
        this.driver = driver;
    }

    @Override
    public SignOutPopup click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getPopupElement();
        getElement().click();
        return new SignOutPopup(driver, popupElement);
    }

    private void getPopupElement() {
        WebElement baseElement = driver.findElement(By.xpath("//div[@id='mainDiv']/div/nav/div"));
        popupElement = baseElement.findElement(By.xpath(".//ul[@class='nav navbar-nav navbar-right']/li"));
    }

}
