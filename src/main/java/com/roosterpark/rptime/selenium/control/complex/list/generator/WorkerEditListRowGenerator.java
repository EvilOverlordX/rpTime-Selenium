package com.roosterpark.rptime.selenium.control.complex.list.generator;

import com.roosterpark.rptime.selenium.control.complex.list.EditButton;
import com.roosterpark.rptime.selenium.control.complex.list.WorkerEditListRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 11/6/13
 * Time: 11:35 AM
 */
public class WorkerEditListRowGenerator {

    private WebDriver driver;
    private List<WebElement> elements;
    private List<WorkerEditListRow> rows;

    public WorkerEditListRowGenerator(WebDriver driver) {
        this.driver = driver;
        rows = new LinkedList<>();
    }

    public List<WorkerEditListRow> generate() {
        getElements();
        for (WebElement element : elements) {
            EditButton editButton = new EditButton(driver, getEditButtonId(element));
            rows.add(new WorkerEditListRow(editButton, getName(element), getEmail(element)));
        }
        return rows;
    }

    private void getElements() {
        elements = driver.findElements(By.tagName("li"));
    }

    private String getEditButtonId(WebElement element) {
        List<WebElement> buttons = element.findElements(By.xpath(".//span[@class='btn-group']/button"));
        for (WebElement button : buttons) {
            String id = button.getAttribute("id");
            if (id.startsWith("edit")) {
                return id;
            }
        }
        return null; // just in case...
    }

    private String getName(WebElement element) {
        return element.getText();
    }

    private String getEmail(WebElement element) {
        WebElement spanElement = element.findElement(By.xpath(".//span[@class='text-muted ng-binding']"));
        return spanElement.getText();
    }

}
