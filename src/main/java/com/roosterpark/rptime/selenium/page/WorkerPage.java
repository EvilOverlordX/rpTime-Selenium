package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.NavBarPageObject;
import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerEditList;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/22/13
 * Time: 2:55 PM
 */
public class WorkerPage extends NavBarPageObject {

    private CreateWorkerForm createWorkerForm;
    private WorkerEditList workerEditList;

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

    public void initWorkerEditList() {
        workerEditList = new WorkerEditList(getWebDriver());
        workerEditList.init();
    }

    public WorkerEditList getWorkerEditList() {
        return workerEditList;
    }

    public CreateWorkerForm getCreateWorkerForm() {
        NewButton newButton = new NewButton(getWebDriver());
        newButton.click();
        return createWorkerForm;
    }

    public void waitForWorkersRedraw() {
        WebElement workersDiv = getWebDriver().findElement(By.id("workers"));
        WebElement workersHeader = workersDiv.findElement(By.xpath(".//div[@class='panel-heading']/h4"));
        WaitForVisible waitForVisible = new WaitForVisible(workersHeader);
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
