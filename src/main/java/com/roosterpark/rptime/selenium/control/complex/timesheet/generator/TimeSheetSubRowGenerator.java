package com.roosterpark.rptime.selenium.control.complex.timesheet.generator;

import com.roosterpark.rptime.selenium.control.TextField;
import com.roosterpark.rptime.selenium.control.complex.timesheet.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * User: John
 * Date: 12/3/13
 * Time: 11:28 AM
 */
public class TimeSheetSubRowGenerator {

    private WebDriver driver;
    private WebElement parentElement;
    private TimeSheetRow homeRow;

    private String startId;
    private String endId;
    private String clientButtonId;
    private String addButtonId;
    private String removeButtonId;
    private WebElement menuElement;
    private WebElement buttonElement;

    public TimeSheetSubRowGenerator(WebDriver driver, WebElement parentElement, TimeSheetRow homeRow) {
        this.driver = driver;
        this.parentElement = parentElement;
        this.homeRow = homeRow;
    }

    public TimeSheetSubRow generateDefault() {
        return generate(false);
    }

    public TimeSheetSubRow generateNew() {
        return generate(true);
    }

    private TimeSheetSubRow generate(boolean isNew) {
        getInputIds();
        getButtonIds();
        getMenuElement();
        getButtonElement();
        TextField clockIn = new TextField(driver, startId);
        TextField clockOut = new TextField(driver, endId);
        ClientDropDownButton button = new ClientDropDownButton(driver, clientButtonId, menuElement);
        AddButton addButton = new AddButton(driver, addButtonId);
        RemoveButton removeButton = new RemoveButton(driver, removeButtonId);
        TimeSheetSubRow subRow = new TimeSheetSubRow(clockIn, clockOut, addButton, removeButton, button);
        subRow.setHomeRow(homeRow);
        subRow.setButtonsElement(buttonElement);
        if (isNew) {
            subRow.setDeletable(true);
        }
        return subRow;
    }

    private void getInputIds() {
        List<WebElement> elements = parentElement.findElements(By.xpath(".//div/div/div/input"));
        for (WebElement element: elements) {
            String id = element.getAttribute("id").trim();
            if (id.startsWith("entry-start")) {
                startId = id;
            } else if (id.startsWith("entry-end")) {
                endId = id;
            }
        }
    }

    private void getButtonIds() {
        List<WebElement> elements = parentElement.findElements(By.xpath(".//div/div/div/div/button"));
        for (WebElement element: elements) {
            String id = element.getAttribute("id").trim();
            if (id.startsWith("timeSheetLogEntry")) {
                clientButtonId = id;
            } else if (id.startsWith("remove-")) {
                removeButtonId = id;
            } else if (id.startsWith("add-")) {
                addButtonId = id;
            }
        }
    }

    private void getMenuElement() {
        menuElement = parentElement.findElement(By.xpath(".//div/div/div/div/ul"));
    }

    private void getButtonElement() {
        List<WebElement> elements = parentElement.findElements(By.xpath(".//div/div/div"));
        for (WebElement element: elements) {
            String classText = element.getAttribute("class");
            if (!classText.equals("col-sm-3")) {
                buttonElement = element;
            }
        }
    }

}
