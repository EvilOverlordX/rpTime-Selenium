package com.roosterpark.rptime.selenium.control.complex.reports;

import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerLink;
import com.roosterpark.rptime.selenium.control.complex.reports.generator.TimeSheetsReportRowGenerator;
import com.roosterpark.rptime.selenium.page.WorkerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 1/20/14
 * Time: 11:50 AM
 */
public class TimeSheetsReportTable {

    private WorkerLink workerLink;
    private List<TimeSheetsReportRow> rows;
    private Map<String, TimeSheetsReportRow> rowsByDate;
    private WebElement parentElement;
    private WebDriver driver;

    public TimeSheetsReportTable(WorkerLink workerLink, WebDriver driver, WebElement parentElement) {
        this.workerLink = workerLink;
        this.parentElement = parentElement;
        this.driver = driver;
        rowsByDate = new HashMap<>();
    }

    public void initialize() {
        TimeSheetsReportRowGenerator generator = new TimeSheetsReportRowGenerator(driver, parentElement);
        rows = generator.generate();
        for (TimeSheetsReportRow row : rows) {
            rowsByDate.put(row.getDate(), row);
        }
    }

    public WorkerPage clickWorkerLink() {
        return workerLink.click();
    }

    public List<TimeSheetsReportRow> getRows() {
        return rows;
    }

    public TimeSheetsReportRow getRowByDate(String date) {
        return rowsByDate.get(date);
    }

}
