package com.roosterpark.rptime.selenium.control.complex;

import com.roosterpark.rptime.selenium.page.ClientPage;
import com.roosterpark.rptime.selenium.page.HistoryPage;
import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.WorkerPage;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/23/13
 * Time: 1:23 PM
 */
public class AdminNavBar {

    private WebDriver driver;
    private HistoryLink historyLink;
    private HomeLink homeLink;
    private ClientsLink clientsLink;
    private WorkersLink workersLink;

    public AdminNavBar(WebDriver driver) {
        this.driver = driver;
        historyLink = new HistoryLink(driver);
        homeLink = new HomeLink(driver);
        clientsLink = new ClientsLink(driver);
        workersLink = new WorkersLink(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HistoryPage clickHistoryLink() {
        return historyLink.click();
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

}
