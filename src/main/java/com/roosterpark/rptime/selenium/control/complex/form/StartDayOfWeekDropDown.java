package com.roosterpark.rptime.selenium.control.complex.form;

import com.roosterpark.rptime.selenium.control.DropDownList;
import com.roosterpark.rptime.selenium.control.Option;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * User: John
 * Date: 10/30/13
 * Time: 3:10 PM
 */
public class StartDayOfWeekDropDown extends DropDownList {

    private static final String ID = "startDayOfWeek";

    private static final Option SUNDAY = new Option("Sunday", "0");
    private static final Option MONDAY = new Option("Monday", "1");
    private static final Option TUESDAY = new Option("Tuesday", "2");
    private static final Option WEDNESDAY = new Option("Wednesday", "3");
    private static final Option THURSDAY = new Option("Thursday", "4");
    private static final Option FRIDAY = new Option("Friday", "5");
    private static final Option SATURDAY = new Option("Saturday", "6");

    private final List<Option> options = new ArrayList<>();

    public StartDayOfWeekDropDown(WebDriver driver) {
        super(driver, ID);
        options.add(SUNDAY);
        options.add(MONDAY);
        options.add(TUESDAY);
        options.add(WEDNESDAY);
        options.add(THURSDAY);
        options.add(FRIDAY);
        options.add(SATURDAY);
    }

    public List<Option> getOptions() {
        return options;
    }

    public void selectByValue(int value) {
        getSelect().selectByIndex(value);
    }

    public void deselectByValue(int value) {
        getSelect().deselectByIndex(value);
    }

    public void selectByText(String text) {
        getSelect().selectByVisibleText(text);
    }

    public void deselectByText(String text) {
        getSelect().deselectByVisibleText(text);
    }

    public String getSelectedDay() {
        return getElement().getText().trim();
    }

}
