package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.NavBarPageObject;
import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/22/13
 * Time: 2:55 PM
 */
public class WorkerPage extends NavBarPageObject {

    private CreateWorkerForm createWorkerForm;

    public WorkerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Worker page should not be opened directly.");
    }

    public void initWorkerForm() {
        createWorkerForm = new CreateWorkerForm(getWebDriver());
    }

    public CreateWorkerForm getCreateWorkerForm() {
        NewButton newButton = new NewButton(getWebDriver());
        newButton.click();
        return createWorkerForm;
    }

    private class NewButton extends Button<Void> {

        private static final String NEW_BUTTON = "new";

        public NewButton(WebDriver driver) {
            super(driver, NEW_BUTTON);
        }

        @Override
        public Void click() {
            getElement().click();
            return null;
        }
    }

}
