package com.roosterpark.rptime.selenium.control.complex.list.generator;

import com.roosterpark.rptime.selenium.control.complex.list.EditButton;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerEditListRow;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerLink;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
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
            WorkerLink link = new WorkerLink(driver, getLinkId(element));
            rows.add(new WorkerEditListRow(link, getEmail(element)));
        }
        return rows;
    }

    private void getElements() {
        elements = driver.findElements(By.xpath("//div[@id='mainDiv']/div/div/div/div/div/div/div/div/ul/li"));
    }

    private String getLinkId(WebElement element) {
        String baseText = element.getText().trim();
        String[] parts = baseText.split(" ");
        return parts[0] + " " + parts[1];
    }

    private String getEmail(WebElement element) {
        String baseText = element.getText().trim();
        String[] parts = baseText.split(" ");
        return parts[parts.length - 1];
    }

}
