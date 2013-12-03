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
    private WebElement menuElement;

    public ClientDropDownPopupGenerator(WebDriver driver, WebElement menuElement) {
        this.driver = driver;
        this.menuElement = menuElement;
    }

    public ClientDropDownPopup generate() {
        return new ClientDropDownPopup(driver, menuElement, getLinks());
    }

    private List<ClientDropDownLink> getLinks() {
        List<ClientDropDownLink> links = new LinkedList<>();
        List<WebElement> elements = menuElement.findElements(By.xpath(".//li"));
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
