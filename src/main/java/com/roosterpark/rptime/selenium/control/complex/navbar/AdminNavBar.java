package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.complex.navbar.link.*;
import com.roosterpark.rptime.selenium.exception.InoperableControlException;
import com.roosterpark.rptime.selenium.page.admin.*;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/23/13
 * Time: 1:23 PM
 */
public class AdminNavBar {

    private WebDriver driver;
    private boolean reportsSelected = false;

    public AdminNavBar(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage clickHomeLink() {
        reportsSelected = false;
        HomeLink homeLink = new HomeLink(driver);
        return homeLink.click();
    }

    public ClientPage clickClientsLink() {
        reportsSelected = false;
        ClientsLink clientsLink = new ClientsLink(driver);
        return clientsLink.click();
    }

    public WorkerPage clickWorkersLink() {
        reportsSelected = false;
        WorkersLink workersLink = new WorkersLink(driver);
        return workersLink.click();
    }

    public ContractsPage clickContractsLink() {
        reportsSelected = false;
        ContractsLink contractsLink = new ContractsLink(driver);
        return contractsLink.click();
    }

    public ReportsPopup clickReportDropDown() {
        reportsSelected = true;
        ReportDropDown reportDropDown = new ReportDropDown(driver);
        return reportDropDown.click();
    }

    public TimeSheetAdminPage clickTimeSheetsAdminLink() {
        reportsSelected = false;
        TimeSheetsAdminLink timeSheetsAdminLink = new TimeSheetsAdminLink(driver);
        return timeSheetsAdminLink.click();
    }

    public MyTimeSheetsPage clickMyTimeSheetsLink() {
        reportsSelected = false;
        MyTimeSheetsLink myTimeSheetsLink = new MyTimeSheetsLink(driver);
        return myTimeSheetsLink.click();
    }

    public void clickPrintButton() {
        if (!reportsSelected) {
            throw new InoperableControlException("Reports drop down needs to be selected!");
        } else {
            PrintButton printButton = new PrintButton(driver);
            printButton.click();
        }
    }

    public StatsPage clickStatsLink() {
        reportsSelected = false;
        StatsLink statsLink = new StatsLink(driver);
        return statsLink.click();
    }

}
