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
    private String worker;

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
        worker = workerLink.getElement().getText().trim();
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

    public String getWorker() {
        return worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSheetsReportTable that = (TimeSheetsReportTable) o;

        if (driver != null ? !driver.equals(that.driver) : that.driver != null) return false;
        if (parentElement != null ? !parentElement.equals(that.parentElement) : that.parentElement != null)
            return false;
        if (rows != null ? !rows.equals(that.rows) : that.rows != null) return false;
        if (rowsByDate != null ? !rowsByDate.equals(that.rowsByDate) : that.rowsByDate != null) return false;
        if (worker != null ? !worker.equals(that.worker) : that.worker != null) return false;
        if (workerLink != null ? !workerLink.equals(that.workerLink) : that.workerLink != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workerLink != null ? workerLink.hashCode() : 0;
        result = 31 * result + (rows != null ? rows.hashCode() : 0);
        result = 31 * result + (rowsByDate != null ? rowsByDate.hashCode() : 0);
        result = 31 * result + (parentElement != null ? parentElement.hashCode() : 0);
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        result = 31 * result + (worker != null ? worker.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TimeSheetsReportTable{" +
                "workerLink=" + workerLink +
                ", rows=" + rows +
                ", rowsByDate=" + rowsByDate +
                ", parentElement=" + parentElement +
                ", driver=" + driver +
                ", worker='" + worker + '\'' +
                '}';
    }

}
