package com.roosterpark.rptime.selenium.control.complex.timesheet.generator;

import com.roosterpark.rptime.selenium.control.TextField;
import com.roosterpark.rptime.selenium.control.complex.timesheet.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
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

    public List<TimeSheetSubRow> generate() {
        List<TimeSheetSubRow> subRows = new LinkedList<>();
        List<WebElement> elements = findSubRows();
        for (WebElement element: elements) {
            getInputIds(element);
            getButtonIds(element);
            getMenuElement(element);
            getButtonElement(element);
            TextField clockIn = new TextField(driver, startId);
            TextField clockOut = new TextField(driver, endId);
            ClientDropDownButton button = new ClientDropDownButton(driver, clientButtonId, menuElement);
            AddButton addButton = new AddButton(driver, addButtonId);
            RemoveButton removeButton = new RemoveButton(driver, removeButtonId);
            TimeSheetSubRow subRow = new TimeSheetSubRow(clockIn, clockOut, addButton, removeButton, button);
            subRow.setHomeRow(homeRow);
            subRow.setButtonsElement(buttonElement);
            subRows.add(subRow);
        }
        int count = subRows.size();
        subRows.get(count - 1).isDeletable();
        return subRows;
    }

    private List<WebElement> findSubRows() {
        return parentElement.findElements(By.xpath(".//div[@class='col-sm-8']/div[@class='row ng-scope']"));
    }

    private void getInputIds(WebElement subRowElement) {
        List<WebElement> elements = subRowElement.findElements(By.xpath(".//div/input"));
        for (WebElement element: elements) {
            String id = element.getAttribute("id").trim();
            if (id.startsWith("entry-start")) {
                startId = id;
            } else if (id.startsWith("entry-end")) {
                endId = id;
            }
        }
    }

    private void getButtonIds(WebElement subRowElement) {
        List<WebElement> elements = subRowElement.findElements(By.xpath(".//div/div/button"));
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

    private void getMenuElement(WebElement subRowElement) {
        List<WebElement> someElements = subRowElement.findElements(By.xpath(".//div"));
        for (WebElement element: someElements) {
            if(element.getAttribute("class").contains("col-sm-6")) {
                menuElement = element.findElement(By.xpath(".//div/ul"));
            }
        }
    }

    private void getButtonElement(WebElement subRowElement) {
        List<WebElement> elements = subRowElement.findElements(By.xpath(".//div"));
        for (WebElement element: elements) {
            String classText = element.getAttribute("class");
            if (!classText.equals("col-sm-3")) {
                buttonElement = element;
            }
        }
    }

}
