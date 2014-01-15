package com.roosterpark.rptime.selenium.control.reports;

/**
 * User: John
 * Date: 1/15/14
 * Time: 10:36 AM
 */
public enum Months {

    JANUARY("January"),
    FEBRUARY("February"),
    MARCH("March"),
    APRIL("April"),
    MAY("May"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December");

    private String text;

    private Months(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
