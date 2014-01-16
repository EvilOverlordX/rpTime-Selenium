package com.roosterpark.rptime.selenium.control.complex.reports.generator;

import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerLink;
import com.roosterpark.rptime.selenium.control.complex.reports.TotalHoursReportRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 1/15/14
 * Time: 3:31 PM
 */
public class TotalHoursReportRowGenerator {

    private WebDriver driver;
    private WebElement parentElement;

    public TotalHoursReportRowGenerator(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.parentElement = element;
    }

    public List<TotalHoursReportRow> generate() {
        List<TotalHoursReportRow> rows = new LinkedList<>();
        List<WebElement> tableRows = getTableRowElements(getTableBodyElement());
        for (WebElement tableRow: tableRows) {
            WorkerLink workerLink = new WorkerLink(driver, getWorkerLinkId(tableRow));
            String hours = getHours(tableRow);
            rows.add(new TotalHoursReportRow(workerLink, hours));
        }
        return rows;
    }

    private WebElement getTableBodyElement() {
        return parentElement.findElement(By.xpath(".//tbody"));
    }

    private List<WebElement> getTableRowElements(WebElement element) {
        return element.findElements(By.xpath(".//tr"));
    }

    private String getWorkerLinkId(WebElement element) {
        WebElement link = element.findElement(By.xpath(".//td/a"));
        return link.getAttribute("id").trim();
    }

    private String getHours(WebElement element) {
        WebElement paragraph = element.findElement(By.xpath(".//td/p"));
        String baseText = paragraph.getText().trim();
        String[] parts = baseText.split(" ");
        return parts[0];
    }

}
