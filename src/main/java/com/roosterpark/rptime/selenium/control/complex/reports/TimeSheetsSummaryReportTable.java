package com.roosterpark.rptime.selenium.control.complex.reports;

import com.roosterpark.rptime.selenium.control.complex.reports.generator.TimeSheetsSummaryReportRowGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 1/17/14
 * Time: 2:37 PM
 */
public class TimeSheetsSummaryReportTable {

    private static final String ID = "summary";

    private WebDriver driver;
    private List<TimeSheetsSummaryReportRow> rows;
    private Map<String, TimeSheetsSummaryReportRow> rowsByWorker;
    private Integer totalWorkers;

    public TimeSheetsSummaryReportTable(WebDriver driver) {
        this.driver = driver;
        rowsByWorker = new HashMap<>();
    }

    public void initialize() {
        TimeSheetsSummaryReportRowGenerator generator = new TimeSheetsSummaryReportRowGenerator(driver, getElement());
        rows = generator.generate();
        totalWorkers = rows.size();
        for (TimeSheetsSummaryReportRow row : rows) {
            rowsByWorker.put(row.getWorker(), row);
        }
    }

    public Integer getTotalWorkers() {
        return totalWorkers;
    }

    public List<TimeSheetsSummaryReportRow> getAllRows() {
        return rows;
    }

    public TimeSheetsSummaryReportRow getRowByWorker(String worker) {
        return rowsByWorker.get(worker);
    }

    private WebElement getElement() {
        return driver.findElement(By.id(ID));
    }

}
