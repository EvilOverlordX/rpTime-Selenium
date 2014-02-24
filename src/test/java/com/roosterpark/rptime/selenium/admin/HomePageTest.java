package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.admin.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: John
 * Date: 1/29/14
 * Time: 2:47 PM
 */
public class HomePageTest extends BasicSeleniumTest {

    private LoginMule loginMule;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void workersLinkTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        homePage.pauseForRedraw();
        WorkerPage workerPage = homePage.clickWorkersLink();
        workerPage.pauseForRedraw();
        assertTrue("Not on Workers page!", workerPage.isWorkerPage());
        assertTrue("Admin warning not visible!", workerPage.isAdminWarningVisible());
        workerPage.close();
    }

    @Test
    public void clientsLinkTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        homePage.pauseForRedraw();
        ClientPage clientPage = homePage.clickClientsLink();
        clientPage.pauseForRedraw();
        assertTrue("Not on Clients page!", clientPage.isClientPage());
        assertTrue("Admin warning not visible!", clientPage.isAdminWarningVisible());
        clientPage.close();
    }

    @Test
    public void contractsLinkTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        homePage.pauseForRedraw();
        ContractsPage contractsPage = homePage.clickContractsLink();
        contractsPage.pauseForRedraw();
        assertTrue("Not on Contracts page!", contractsPage.isContractsPage());
        assertTrue("Admin warning not visible!", contractsPage.isAdminWarningVisible());
        contractsPage.close();
    }

    @Test
    public void hoursPerWorkerMonthReportLinkTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        homePage.pauseForRedraw();
        HoursPerWorkerMonthReportPage hoursPerWorkerMonthReportPage = homePage.clickHoursPerWorkerMonthReportLink();
        hoursPerWorkerMonthReportPage.pauseForRedraw();
        assertTrue("Not on Hours Per Worker Month Report page!", hoursPerWorkerMonthReportPage.isHoursPerWorkerMonthReportPage());
        assertTrue("Admin warning not visible!", hoursPerWorkerMonthReportPage.isAdminWarningVisible());
        hoursPerWorkerMonthReportPage.close();
    }

    @Test
    public void timeSheetsPerWorkerMonthClientReportLinkTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        homePage.pauseForRedraw();
        TimeSheetsPerWorkerMonthClientReportPage tspwmcrPage = homePage.clickTimeSheetsPerWorkerMonthClientReportLink();
        tspwmcrPage.pauseForRedraw();
        assertTrue("Not on Time Sheets per Worker/Month/Client page!", tspwmcrPage.isTimeSheetsPerWorkerMonthClientReportPage());
        assertTrue("Admin warning not visible!", tspwmcrPage.isAdminWarningVisible());
        tspwmcrPage.close();
    }

}
