package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.exception.InoperableControlException;
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
    private TimeSheetsAdminLink timeSheetsAdminLink;
    private MyTimeSheetsLink myTimeSheetsLink;
    private ReportDropDown reportDropDown;
    private PrintButton printButton;

    private boolean reportsSelected = false;

    public AdminNavBar(WebDriver driver) {
        this.driver = driver;
        homeLink = new HomeLink(driver);
        clientsLink = new ClientsLink(driver);
        workersLink = new WorkersLink(driver);
        contractsLink = new ContractsLink(driver);
        reportDropDown = new ReportDropDown(driver);
        timeSheetsAdminLink = new TimeSheetsAdminLink(driver);
        myTimeSheetsLink = new MyTimeSheetsLink(driver);
        printButton = new PrintButton(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage clickHomeLink() {
        reportsSelected = false;
        return homeLink.click();
    }

    public ClientPage clickClientsLink() {
        reportsSelected = false;
        return clientsLink.click();
    }

    public WorkerPage clickWorkersLink() {
        reportsSelected = false;
        return workersLink.click();
    }

    public ContractsPage clickContractsLink() {
        reportsSelected = false;
        return contractsLink.click();
    }

    public ReportsPopup clickReportDropDown() {
        reportsSelected = true;
        return reportDropDown.click();
    }

    public TimeSheetAdminPage clickTimeSheetsAdminLink() {
        reportsSelected = false;
        return timeSheetsAdminLink.click();
    }

    public MyTimeSheetsPage clickMyTimeSheetsLink() {
        reportsSelected = false;
        return myTimeSheetsLink.click();
    }

    public void clickPrintButton() {
        if (!reportsSelected) {
            throw new InoperableControlException("Reports drop down needs to be selected!");
        } else {
            printButton.click();
        }
    }

}
