package com.roosterpark.rptime.selenium.control.complex.reports;

import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerLink;
import com.roosterpark.rptime.selenium.page.WorkerPage;

/**
 * User: John
 * Date: 1/17/14
 * Time: 10:04 AM
 */
public class TimeSheetsReportRow {

    private WorkerLink workerLink;
    private Integer totalDays;
    private Double totalHours;
    private String worker;

    public TimeSheetsReportRow(WorkerLink workerLink, Integer totalDays, Double totalHours, String worker) {
        this.workerLink = workerLink;
        this.totalDays = totalDays;
        this.totalHours = totalHours;
        this.worker = worker;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public String getWorker() {
        return worker;
    }

    public WorkerPage clickWorkerLink() {
        return workerLink.click();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSheetsReportRow that = (TimeSheetsReportRow) o;

        if (totalDays != null ? !totalDays.equals(that.totalDays) : that.totalDays != null) return false;
        if (totalHours != null ? !totalHours.equals(that.totalHours) : that.totalHours != null) return false;
        if (worker != null ? !worker.equals(that.worker) : that.worker != null) return false;
        if (workerLink != null ? !workerLink.equals(that.workerLink) : that.workerLink != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workerLink != null ? workerLink.hashCode() : 0;
        result = 31 * result + (totalDays != null ? totalDays.hashCode() : 0);
        result = 31 * result + (totalHours != null ? totalHours.hashCode() : 0);
        result = 31 * result + (worker != null ? worker.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TimeSheetsReportRow{" +
                "workerLink=" + workerLink +
                ", totalDays=" + totalDays +
                ", totalHours=" + totalHours +
                ", worker='" + worker + '\'' +
                '}';
    }

}
