package com.roosterpark.rptime.selenium.page.admin;

import com.roosterpark.rptime.selenium.AdminPageObject;
import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.control.complex.form.CreateClientForm;
import com.roosterpark.rptime.selenium.control.complex.list.client.ClientEditList;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:05 PM
 */
public class ClientPage extends AdminPageObject {

    private ClientEditList clientEditList;

    public ClientPage(WebDriver driver) {
        super(driver);
        clientEditList = new ClientEditList(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Client page should not be opened directly.");
    }


    public CreateClientForm getCreateClientForm() {
        NewButton newButton = new NewButton(getWebDriver());
        newButton.click();
        return new CreateClientForm(getWebDriver());
    }

    public void initClientEditList() {
        clientEditList = new ClientEditList(getWebDriver());
        clientEditList.init();
    }

    public ClientEditList getClientEditList() {
        return clientEditList;
    }

    public void waitForClientsRedraw() {
        WebElement clientsDiv = getWebDriver().findElement(By.id("clients"));
        WebElement clientsHeader = clientsDiv.findElement(By.xpath(".//div[@class='panel-heading']/h4"));
        WaitForVisible waitForVisible = new WaitForVisible(clientsHeader);
        waitForVisible.defaultWaitForVisible();
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
