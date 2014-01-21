package com.roosterpark.rptime.selenium.control.complex.reports;

import com.roosterpark.rptime.selenium.page.MyTimeSheetsPage;

/**
 * User: John
 * Date: 1/21/14
 * Time: 1:36 PM
 */
public class TimeSheetsReportRow {

    private MyTimeSheetsLink myTimeSheetsLink;
    private Double hours;
    private FlagButton flagButton;
    private String date;

    public TimeSheetsReportRow(MyTimeSheetsLink myTimeSheetsLink, Double hours, FlagButton flagButton, String date) {
        this.myTimeSheetsLink = myTimeSheetsLink;
        this.hours = hours;
        this.flagButton = flagButton;
        this.date = date;
    }

    public TimeSheetsReportRow(MyTimeSheetsLink myTimeSheetsLink, String hours, FlagButton flagButton, String date) {
        this.myTimeSheetsLink = myTimeSheetsLink;
        this.hours = Double.valueOf(hours);
        this.flagButton = flagButton;
        this.date = date;
    }

    public MyTimeSheetsPage clickMyTimeSheetsLink() {
        return myTimeSheetsLink.click();
    }

    public Double getHours() {
        return hours;
    }

    public String getDate() {
        return date;
    }

    public void clickFlagButton() {
        flagButton.click();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSheetsReportRow that = (TimeSheetsReportRow) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (flagButton != null ? !flagButton.equals(that.flagButton) : that.flagButton != null) return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;
        if (myTimeSheetsLink != null ? !myTimeSheetsLink.equals(that.myTimeSheetsLink) : that.myTimeSheetsLink != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = myTimeSheetsLink != null ? myTimeSheetsLink.hashCode() : 0;
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (flagButton != null ? flagButton.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TimeSheetsReportRow{" +
                "myTimeSheetsLink=" + myTimeSheetsLink +
                ", hours=" + hours +
                ", flagButton=" + flagButton +
                ", date='" + date + '\'' +
                '}';
    }

}
