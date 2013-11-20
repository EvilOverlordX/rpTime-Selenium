package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.page.*;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/23/13
 * Time: 1:23 PM
 */
public class AdminNavBar {

    private WebDriver driver;
    private HomeLink homeLink;
    private ClientsLink clientsLink;
    private WorkersLink workersLink;
    private ContractsLink contractsLink;
    private ReportDropDown reportDropDown;

    public AdminNavBar(WebDriver driver) {
        this.driver = driver;
        homeLink = new HomeLink(driver);
        clientsLink = new ClientsLink(driver);
        workersLink = new WorkersLink(driver);
        contractsLink = new ContractsLink(driver);
        reportDropDown = new ReportDropDown(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage clickHomeLink() {
        return homeLink.click();
    }

    public ClientPage clickClientsLink() {
        return clientsLink.click();
    }

    public WorkerPage clickWorkersLink() {
        return workersLink.click();
    }

    public ContractsPage clickContractsLink() {
        return contractsLink.click();
    }

    public ReportsPopup clickReportDropDown() {
        return reportDropDown.click();
    }

}
