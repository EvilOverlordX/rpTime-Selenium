package com.roosterpark.rptime.selenium.control.complex.timesheet.generator;

import com.roosterpark.rptime.selenium.control.complex.timesheet.ClientDropDownLink;
import com.roosterpark.rptime.selenium.control.complex.timesheet.ClientDropDownPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 11/27/13
 * Time: 10:55 AM
 */
public class ClientDropDownPopupGenerator {

    private WebDriver driver;
    private WebElement parentElement;

    public ClientDropDownPopupGenerator(WebDriver driver, WebElement parentElement) {
        this.driver = driver;
        this.parentElement = parentElement;
    }

    public ClientDropDownPopup generate() {
        return new ClientDropDownPopup(driver, getPopupElement(), getLinks());
    }

    private WebElement getPopupElement() {
        return parentElement.findElement(By.xpath(".//ul[@class='dropdown-menu']"));
    }

    private List<ClientDropDownLink> getLinks() {
        List<ClientDropDownLink> links = new LinkedList<>();
        List<WebElement> elements = parentElement.findElements(By.xpath(".//ul[@class='dropdown-menu']/li"));
        for (WebElement element : elements) {
            if (element.getText().trim().equals("-- Select Client--")) {
                // Do nothing
            } else {
                links.add(new ClientDropDownLink(driver, element.getText()));
            }
        }
        return links;
    }

}
