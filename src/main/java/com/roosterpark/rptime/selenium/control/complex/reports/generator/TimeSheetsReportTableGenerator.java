package com.roosterpark.rptime.selenium.control.complex.reports.generator;

import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerLink;
import com.roosterpark.rptime.selenium.control.complex.reports.TimeSheetsReportTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 1/20/14
 * Time: 2:15 PM
 */
public class TimeSheetsReportTableGenerator {

    private static final String DIV_ID = "workerTableDiv";

    private WebDriver driver;

    public TimeSheetsReportTableGenerator(WebDriver driver) {
        this.driver = driver;
    }

    public List<TimeSheetsReportTable> generate() {
        List<TimeSheetsReportTable> tables = new LinkedList<>();
        List<WebElement> tableElements = getTableElements();
        for (WebElement tableElement : tableElements) {
            WorkerLink workerLink = new WorkerLink(driver, getWorkerLinkId(tableElement));
            TimeSheetsReportTable table = new TimeSheetsReportTable(workerLink, driver, getTableParentElement(tableElement));
            table.initialize();
            tables.add(table);
        }
        return tables;
    }

    private List<WebElement> getTableElements() {
        return driver.findElements(By.id(DIV_ID));
    }

    private String getWorkerLinkId(WebElement element) {
        WebElement linkElement = element.findElement(By.xpath(".//h4/a"));
        return linkElement.getAttribute("id");
    }

    private WebElement getTableParentElement(WebElement element) {
        WebElement tableElement = element.findElement(By.xpath(".//div/table"));
        return tableElement.findElement(By.xpath(".//tbody"));
    }

}
