package com.roosterpark.rptime.selenium.control.complex.list.generator;

import com.roosterpark.rptime.selenium.control.complex.list.client.ClientEditListRow;
import com.roosterpark.rptime.selenium.control.complex.list.client.ClientLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 11/12/13
 * Time: 1:34 PM
 */
public class ClientEditListRowGenerator {

    private WebDriver driver;
    private List<WebElement> elements;
    private List<ClientEditListRow> rows;

    public ClientEditListRowGenerator(WebDriver driver) {
        this.driver = driver;
        rows = new LinkedList<>();
    }

    public List<ClientEditListRow> generate() {
        getElements();
        for (WebElement element : elements) {
            String name = getLinkName(element);
            ClientLink clientLink = new ClientLink(driver, name);
            rows.add(new ClientEditListRow(clientLink, name));
        }
        return rows;
    }

    private void getElements() {
        elements = driver.findElements(By.xpath("//div[@id='mainDiv']/div/div/div/div/div/div/ul/li"));
    }

    private String getLinkName(WebElement element) {
        WebElement link = element.findElement(By.xpath(".//a"));
        return link.getText().trim();
    }

}
