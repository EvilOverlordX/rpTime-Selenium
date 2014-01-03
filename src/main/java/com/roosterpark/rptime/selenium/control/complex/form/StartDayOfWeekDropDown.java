package com.roosterpark.rptime.selenium.control.complex.form;

import com.roosterpark.rptime.selenium.control.DropDownList;
import com.roosterpark.rptime.selenium.control.ListItem;
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

    private static final ListItem SUNDAY = new ListItem(0, "Sunday");
    private static final ListItem MONDAY = new ListItem(1, "Monday");
    private static final ListItem TUESDAY = new ListItem(2, "Tuesday");
    private static final ListItem WEDNESDAY = new ListItem(3, "Wednesday");
    private static final ListItem THURSDAY = new ListItem(4, "Thursday");
    private static final ListItem FRIDAY = new ListItem(5, "Friday");
    private static final ListItem SATURDAY = new ListItem(6, "Saturday");

    private final List<ListItem> options = new ArrayList<>();

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

    public List<ListItem> getOptions() {
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
        return getSelect().getFirstSelectedOption().getText().trim();
    }

}
