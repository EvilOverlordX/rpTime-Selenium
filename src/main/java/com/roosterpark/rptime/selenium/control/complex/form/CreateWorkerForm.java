package com.roosterpark.rptime.selenium.control.complex.form;

import com.roosterpark.rptime.selenium.control.CheckBox;
import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.control.TextField;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/28/13
 * Time: 2:30 PM
 */
public class CreateWorkerForm {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String START_DATE = "start";
    private static final String HOURLY = "hourly";

    private WebDriver driver;

    private TextField firstNameField;
    private TextField lastNameField;
    private TextField emailField;
    private TextField startDateField;
    private CheckBox hourlyCheckBox;
    private SaveButtonLink saveButtonLink;
    private CancelButtonLink cancelButtonLink;

    public CreateWorkerForm(WebDriver driver) {
        this.driver = driver;
        firstNameField = new TextField(driver, FIRST_NAME);
        lastNameField = new TextField(driver, LAST_NAME);
        emailField = new TextField(driver, EMAIL);
        startDateField = new TextField(driver, START_DATE);
        hourlyCheckBox = new CheckBox(driver, HOURLY);
        saveButtonLink = new SaveButtonLink(driver);
        cancelButtonLink = new CancelButtonLink(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void enterFirstName(String firstName) {
        firstNameField.enterText(firstName);
    }

    public void clearFirstName() {
        firstNameField.clear();
    }

    public void enterLastName(String lastName) {
        lastNameField.enterText(lastName);
    }

    public void clearLastName() {
        lastNameField.clear();
    }

    public void enterEmail(String email) {
        emailField.enterText(email);
    }

    public void clearEmail() {
        emailField.clear();
    }

    public void enterStartDate(String startDate) {
        startDateField.enterText(startDate);
    }

    public void clearDate() {
        startDateField.clear();
    }

    public void clickSave() {
        saveButtonLink.click();
    }

    public void clickCancel() {
        cancelButtonLink.click();
    }

    public void checkHourly() {
        hourlyCheckBox.check();
    }

    public boolean isHourlyChecked() {
        return hourlyCheckBox.isChecked();
    }

    private class SaveButtonLink extends Link<Void> {

        private static final String SAVE_BUTTON = "Save";

        public SaveButtonLink(WebDriver driver) {
            super(driver, SAVE_BUTTON);
        }

        @Override
        public Void click() {
            getElement().click();
            return null;
        }
    }

    private class CancelButtonLink extends Link<Void> {

        private static final String CANCEL_BUTTON = "Cancel";

        public CancelButtonLink(WebDriver driver) {
            super(driver, CANCEL_BUTTON);
        }

        @Override
        public Void click() {
            getElement().click();
            return null;
        }
    }

}
