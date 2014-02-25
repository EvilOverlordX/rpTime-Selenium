package com.roosterpark.rptime.selenium.page.admin;

import com.roosterpark.rptime.selenium.AdminPageObject;
import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.control.finder.FindByHelper.ByXpath;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 10/23/13
 * Time: 1:42 PM
 */
public class HomePage extends AdminPageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Home page should not be opened directly");
    }

    public WorkerPage clickWorkersLink() {
        WorkersLink workersLink = new WorkersLink(getWebDriver());
        return workersLink.click();
    }

    public ClientPage clickClientsLink() {
        ClientsLink clientsLink = new ClientsLink(getWebDriver());
        return clientsLink.click();
    }

    public ContractsPage clickContractsLink() {
        ContractsLink contractsLink = new ContractsLink(getWebDriver());
        return contractsLink.click();
    }

    public HoursPerWorkerMonthReportPage clickHoursPerWorkerMonthReportLink() {
        HoursPerWorkerMonthReportLink hoursPerWorkerMonthReportLink = new HoursPerWorkerMonthReportLink(getWebDriver());
        return hoursPerWorkerMonthReportLink.click();
    }

    public TimeSheetsPerWorkerMonthClientReportPage clickTimeSheetsPerWorkerMonthClientReportLink() {
        TimeSheetsPerWorkerMonthClientReportLink tspwmcrLink = new TimeSheetsPerWorkerMonthClientReportLink(getWebDriver());
        return tspwmcrLink.click();
    }

    public boolean isHomePage() {
        WebElement homeDiv = getWebDriver().findElement(By.id("home"));
        WaitForVisible waitForVisible = new WaitForVisible(homeDiv);
        waitForVisible.defaultWaitForVisible();
        return homeDiv.isDisplayed();
    }

    private class WorkersLink extends Link<WorkerPage> {

        private static final String ID = "//div[@id='mainDiv']/div[@id='rpTimeWrapperDiv']/div/div/div/div/" +
                                         "ul/li/a[@href='#/worker']";

        public WorkersLink(WebDriver driver) {
            super(driver, ID, new ByXpath());
        }

        @Override
        public WorkerPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new WorkerPage(getDriver());
        }
    }

    private class ClientsLink extends Link<ClientPage> {

        private static final String ID = "//div[@id='mainDiv']/div[@id='rpTimeWrapperDiv']/div/div/div/div/" +
                "ul/li/a[@href='#/client']";

        public ClientsLink(WebDriver driver) {
            super(driver, ID, new ByXpath());
        }

        @Override
        public ClientPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new ClientPage(getDriver());
        }
    }

    private class ContractsLink extends Link<ContractsPage> {

        private static final String ID = "//div[@id='mainDiv']/div[@id='rpTimeWrapperDiv']/div/div/div/div/" +
                "ul/li/a[@href='#/contract']";

        public ContractsLink(WebDriver driver) {
            super(driver, ID, new ByXpath());
        }

        @Override
        public ContractsPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new ContractsPage(getDriver());
        }
    }

    private class HoursPerWorkerMonthReportLink extends Link<HoursPerWorkerMonthReportPage> {

        private static final String ID = "Hours per Worker/Month, all Clients";

        public HoursPerWorkerMonthReportLink(WebDriver driver) {
            super(driver, ID);
        }

        @Override
        public HoursPerWorkerMonthReportPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new HoursPerWorkerMonthReportPage(getDriver());
        }

    }

    private class TimeSheetsPerWorkerMonthClientReportLink extends Link<TimeSheetsPerWorkerMonthClientReportPage> {

        private static final String ID = "Time Sheets per Worker/Month/Client";

        public TimeSheetsPerWorkerMonthClientReportLink(WebDriver driver) {
            super(driver, ID);
        }

        @Override
        public TimeSheetsPerWorkerMonthClientReportPage click() {
            WaitForVisible waitForVisible = new WaitForVisible(getElement());
            waitForVisible.defaultWaitForVisible();
            getElement().click();
            return new TimeSheetsPerWorkerMonthClientReportPage(getDriver());
        }

    }

}
