package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.NavBarPageObject;
import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.control.complex.form.CreateClientForm;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:05 PM
 */
public class ClientPage extends NavBarPageObject {

    private CreateClientForm createClientForm;

    public ClientPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Client page should not be opened directly.");
    }

    public void clickNewButton() {
        NewButton newButton = new NewButton(getWebDriver());
        newButton.click();
    }

    public CreateClientForm getCreateClientForm() {
        createClientForm = new CreateClientForm(getWebDriver());
        return createClientForm;
    }

    private class NewButton extends Button<Void> {

        private static final String NEW_BUTTON = "new";

        private WaitForVisible waitForVisible;

        public NewButton(WebDriver driver) {
            super(driver, NEW_BUTTON);
        }

        @Override
        public Void click() {
            waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return null;
        }
    }

}
