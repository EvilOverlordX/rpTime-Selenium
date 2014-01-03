package com.roosterpark.rptime.selenium.control.complex.form;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.control.CheckBox;
import com.roosterpark.rptime.selenium.control.TextField;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/30/13
 * Time: 10:58 AM
 */
public class CreateClientForm {

    private static final String NAME = "name";
    private static final String LUNCH_REQUIRED = "lunchRequired";

    private StartDayOfWeekDropDown startDayOfWeekDropDown;
    private SaveButton saveButton;
    private CancelButton cancelButton;
    private CheckBox lunchRequired;
    private TextField nameField;

    private WebDriver driver;

    public CreateClientForm(WebDriver driver) {
        this.driver = driver;
        nameField = new TextField(driver, NAME);
        lunchRequired = new CheckBox(driver, LUNCH_REQUIRED);
        startDayOfWeekDropDown = new StartDayOfWeekDropDown(driver);
        saveButton = new SaveButton(driver);
        cancelButton = new CancelButton(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void enterName(String name) {
        nameField.enterText(name);
    }

    public void clearName() {
        nameField.clear();
    }

    public void checkLunchRequired() {
        lunchRequired.check();
    }

    public boolean isLunchChecked() {
        return lunchRequired.isChecked();
    }

    public void selectSunday() {
        startDayOfWeekDropDown.selectByText("Sunday");
    }

    public void selectMonday() {
        startDayOfWeekDropDown.selectByText("Monday");
    }

    public void selectTuesday() {
        startDayOfWeekDropDown.selectByText("Tuesday");
    }

    public void selectWednesday() {
        startDayOfWeekDropDown.selectByText("Wednesday");
    }

    public void selectThursday() {
        startDayOfWeekDropDown.selectByText("Thursday");
    }

    public void selectFriday() {
        startDayOfWeekDropDown.selectByText("Friday");
    }

    public void selectSaturday() {
        startDayOfWeekDropDown.selectByText("Saturday");
    }

    public void clickSave() {
        saveButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public boolean hasTextEntered() {
        return nameField.isValid();
    }

    public String getSelectedDayText() {
        return startDayOfWeekDropDown.getSelectedDay();
    }

}
