package com.roosterpark.rptime.selenium.control.reports;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * User: John
 * Date: 1/15/14
 * Time: 10:20 AM
 */
public class ReportDate {

    private static final Map<String, Months> MONTHS_MAP = new HashMap<>();
    private static final Map<Months, Months> PREVIOUS_MAP = new HashMap<>();
    private static final Map<Months, Months> NEXT_MAP = new HashMap<>();

    private Integer year;
    private Months month;

    static {
        MONTHS_MAP.put("January", Months.JANUARY);
        MONTHS_MAP.put("February", Months.FEBRUARY);
        MONTHS_MAP.put("March", Months.MARCH);
        MONTHS_MAP.put("April", Months.APRIL);
        MONTHS_MAP.put("May", Months.MAY);
        MONTHS_MAP.put("June", Months.JUNE);
        MONTHS_MAP.put("July", Months.JULY);
        MONTHS_MAP.put("August", Months.AUGUST);
        MONTHS_MAP.put("September", Months.SEPTEMBER);
        MONTHS_MAP.put("October", Months.OCTOBER);
        MONTHS_MAP.put("November", Months.NOVEMBER);
        MONTHS_MAP.put("December", Months.DECEMBER);

        PREVIOUS_MAP.put(Months.JANUARY, Months.DECEMBER);
        PREVIOUS_MAP.put(Months.FEBRUARY, Months.JANUARY);
        PREVIOUS_MAP.put(Months.MARCH, Months.FEBRUARY);
        PREVIOUS_MAP.put(Months.APRIL, Months.MARCH);
        PREVIOUS_MAP.put(Months.MAY, Months.APRIL);
        PREVIOUS_MAP.put(Months.JUNE, Months.MAY);
        PREVIOUS_MAP.put(Months.JULY, Months.JUNE);
        PREVIOUS_MAP.put(Months.AUGUST, Months.JULY);
        PREVIOUS_MAP.put(Months.SEPTEMBER, Months.AUGUST);
        PREVIOUS_MAP.put(Months.OCTOBER, Months.SEPTEMBER);
        PREVIOUS_MAP.put(Months.NOVEMBER, Months.OCTOBER);
        PREVIOUS_MAP.put(Months.DECEMBER, Months.NOVEMBER);

        NEXT_MAP.put(Months.JANUARY, Months.FEBRUARY);
        NEXT_MAP.put(Months.FEBRUARY, Months.MARCH);
        NEXT_MAP.put(Months.MARCH, Months.APRIL);
        NEXT_MAP.put(Months.APRIL, Months.MAY);
        NEXT_MAP.put(Months.MAY, Months.JUNE);
        NEXT_MAP.put(Months.JUNE, Months.JULY);
        NEXT_MAP.put(Months.JULY, Months.AUGUST);
        NEXT_MAP.put(Months.AUGUST, Months.SEPTEMBER);
        NEXT_MAP.put(Months.SEPTEMBER, Months.OCTOBER);
        NEXT_MAP.put(Months.OCTOBER, Months.NOVEMBER);
        NEXT_MAP.put(Months.NOVEMBER, Months.DECEMBER);
        NEXT_MAP.put(Months.DECEMBER, Months.JANUARY);
    }

    private ReportDate(Months month, Integer year) {
        this.month = month;
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public Months getMonth() {
        return month;
    }

    public static ReportDate getReportDateFromElement(WebElement element) {
        String elementText = element.getText().trim();
        String[] parts = elementText.split(" ");
        return new ReportDate(MONTHS_MAP.get(parts[0]), Integer.valueOf(parts[1]));
    }

    public ReportDate getPreviousMonth() {
        if (this.month.equals(Months.JANUARY)) {
            return new ReportDate(Months.DECEMBER, this.year - 1);
        } else {
            return new ReportDate(PREVIOUS_MAP.get(this.month), this.year);
        }
    }

    public ReportDate getNextMonth() {
        if (this.month.equals(Months.DECEMBER)) {
            return new ReportDate(Months.JANUARY, this.year + 1);
        } else {
            return new ReportDate(NEXT_MAP.get(this.month), this.year);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportDate that = (ReportDate) o;

        if (month != that.month) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = year != null ? year.hashCode() : 0;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReportDate{" +
                "year=" + year +
                ", month=" + month +
                '}';
    }
}
