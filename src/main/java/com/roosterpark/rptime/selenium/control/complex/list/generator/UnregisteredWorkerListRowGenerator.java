package com.roosterpark.rptime.selenium.control.complex.list.generator;

import com.roosterpark.rptime.selenium.control.complex.list.unregistered.UnregisteredUserLink;
import com.roosterpark.rptime.selenium.control.complex.list.unregistered.UnregisteredWorkerListRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 12/30/13
 * Time: 10:23 AM
 */
public class UnregisteredWorkerListRowGenerator {

    private WebDriver driver;

    public UnregisteredWorkerListRowGenerator(WebDriver driver) {
        this.driver = driver;
    }

    public List<UnregisteredWorkerListRow> generate() {
        List<UnregisteredWorkerListRow> rows = new LinkedList<>();
        WebElement baseElement = getUnregisteredUserListElement();
        List<WebElement> elements = baseElement.findElements(By.xpath(".//li/a"));
        for (WebElement element : elements) {
            String email = getEmailFromText(element);
            String id = getIdFromElement(element);
            UnregisteredUserLink link = new UnregisteredUserLink(driver, id);
            rows.add(new UnregisteredWorkerListRow(email, link));
        }
        return rows;
    }

    private WebElement getUnregisteredUserListElement() {
        return driver.findElement(By.id("unregisteredUserList"));
    }

    private String getEmailFromText(WebElement element) {
        String elementText = element.getText().trim();
        String[] parts = elementText.split("\"");
        return parts[1];
    }

    private String getIdFromElement(WebElement element) {
        return element.getAttribute("id");
    }

}
