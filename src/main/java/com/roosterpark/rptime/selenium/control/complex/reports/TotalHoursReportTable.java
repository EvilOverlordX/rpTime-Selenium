package com.roosterpark.rptime.selenium.control.complex.reports;

import com.roosterpark.rptime.selenium.control.complex.reports.generator.TotalHoursReportRowGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 1/16/14
 * Time: 10:30 AM
 */
public class TotalHoursReportTable {

    private static final String ID = "reportTable";

    private WebDriver driver;
    private WebElement element;
    private List<TotalHoursReportRow> rows;
    private Map<String, TotalHoursReportRow> rowsByWorker;
    private Double totalHours;
    private Integer totalWorkers;

    public TotalHoursReportTable(WebDriver driver) {
        this.driver = driver;
        rowsByWorker = new HashMap<>();
    }

    public void initialize() {
        element = driver.findElement(By.id(ID));
        TotalHoursReportRowGenerator generator = new TotalHoursReportRowGenerator(driver, element);
        rows = generator.generate();
        for (TotalHoursReportRow row: rows) {
            rowsByWorker.put(row.getWorker(), row);
        }
        getTotals();
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public Integer getTotalWorkers() {
        return totalWorkers;
    }

    public TotalHoursReportRow getRowByWorker(String worker) {
        return rowsByWorker.get(worker);
    }

    public List<TotalHoursReportRow> getAllRows() {
        return rows;
    }

    private void getTotals() {
        List<WebElement> footerTotals = element.findElements(By.xpath(".//tfoot/tr/td"));
        for (WebElement footerTotal: footerTotals) {
            List<WebElement> paragraphs = footerTotal.findElements(By.xpath(".//p"));
            if (paragraphs.size() == 1) {
                String paragraphText = paragraphs.get(0).getText().trim();
                String[] parts = paragraphText.split(" ");
                totalHours = Double.valueOf(parts[0]);
            } else {
                String workersText = footerTotal.getText().trim();
                String[] parts = workersText.split(" ");
                totalWorkers = Integer.valueOf(parts[0]);
            }
        }
    }

}
