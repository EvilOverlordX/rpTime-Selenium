package com.roosterpark.rptime.selenium.admin.reports;

import com.roosterpark.rptime.selenium.admin.contracts.BasicContractsTest;
import com.roosterpark.rptime.selenium.control.complex.list.timesheet.UserTimeSheetList;
import com.roosterpark.rptime.selenium.control.complex.navbar.NavBar;
import com.roosterpark.rptime.selenium.control.complex.navbar.ReportsPopup;
import com.roosterpark.rptime.selenium.control.complex.reports.TimeSheetsSummaryReportRow;
import com.roosterpark.rptime.selenium.control.complex.reports.TimeSheetsSummaryReportTable;
import com.roosterpark.rptime.selenium.control.complex.timesheet.TimeSheetForm;
import com.roosterpark.rptime.selenium.mule.ContractsMule;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.UserTimeSheetPage;
import com.roosterpark.rptime.selenium.page.admin.ContractsPage;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import com.roosterpark.rptime.selenium.page.admin.TimeSheetsPerWorkerMonthClientReportPage;
import com.roosterpark.rptime.selenium.user.TestUser;
import com.roosterpark.rptime.selenium.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: John
 * Date: 2/20/14
 * Time: 10:11 AM
 *
 * Test assumes new user creation
 */
public class TimeSheetsPerWorkerMonthClientReportTest extends BasicContractsTest {

    private static final String FIRST = "Test";
    private static final String LAST = "User2";
    private static final String EMAIL = "testuser2@roosterpark.com";
    private static final String EMPLOYEE_START = "2013-01-01";
    private static final String DAY_OF_WEEK = "Monday";
    private static final String CONTRACT_START = "2014-01-01";
    private static final String CONTRACT_END = "2014-12-31";
    private static final String WORKER = LAST + ", " + FIRST;

    private ContractsMule contractsMule;
    private LoginMule loginMule;
    private String client;
    private User user;

    @Before
    public void setup() {
        contractsMule = new ContractsMule(getDriver());
        loginMule = new LoginMule(getDriver());
        client = "client-" + System.currentTimeMillis();
        user = new TestUser(EMAIL, "te5tU5er2");
    }

    @Test
    public void timeSheetsPerWorkerMonthClientReportTest() {
        ContractsPage contractsPage = createContract();
        contractsPage.clickSignOutButton();
        UserTimeSheetPage userTimeSheetPage = createTimeSheet();
        userTimeSheetPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        TimeSheetsSummaryReportTable table = getTable(homePage);
        assertEquals("Incorrect worker count!", Integer.valueOf(1), table.getTotalWorkers());
        TimeSheetsSummaryReportRow row = table.getRowByWorker(WORKER);
        assertEquals("Days do not match!", Integer.valueOf(5), row.getTotalDays());
        assertEquals("Total hours do not match!", Double.valueOf(40.00), row.getTotalHours());
        homePage.close();
    }

    private ContractsPage createContract() {
        contractsMule.login();
        contractsMule.addWorker(FIRST, LAST, EMAIL, EMPLOYEE_START, true);
        contractsMule.addClient(client, DAY_OF_WEEK, false);
        ContractsPage contractsPage = contractsMule.createOnSiteContract(client, WORKER, CONTRACT_START, CONTRACT_END);
        verifyContractAdded(contractsPage, client);
        return contractsPage;
    }

    private UserTimeSheetPage createTimeSheet() {
        UserTimeSheetPage userTimeSheetPage = loginMule.loginAsTestDefinedUser(user);
        NavBar navBar = userTimeSheetPage.getNavBar();
        userTimeSheetPage = navBar.clickTimeSheetsLink();
        userTimeSheetPage.pauseForRedraw();
        userTimeSheetPage.pauseForRedraw();
        userTimeSheetPage.initializeTimeSheetForm();
        TimeSheetForm timeSheetForm = userTimeSheetPage.getTimeSheetForm();
        userTimeSheetPage = timeSheetForm.clickSubmitButton();
        userTimeSheetPage.pauseForRedraw();
        userTimeSheetPage.pauseForRedraw();
        userTimeSheetPage.initializeUserTimeSheetList();
        UserTimeSheetList userTimeSheetList = userTimeSheetPage.getUserTimeSheetList();
        assertEquals("Time Sheet count incorrect!", Integer.valueOf(1), userTimeSheetList.getTimeSheetCount());
        return userTimeSheetPage;
    }

    private TimeSheetsSummaryReportTable getTable(HomePage homePage) {
        ReportsPopup popup = homePage.getNavBar().clickReportDropDown();
        TimeSheetsPerWorkerMonthClientReportPage tspwmcrPage = popup.clickTimeSheetsPerWorkerMonthClientReportLink();
        tspwmcrPage.pauseForRedraw();
        tspwmcrPage.selectClient(client);
        tspwmcrPage.pauseForRedraw();
        tspwmcrPage.pauseForRedraw();
        tspwmcrPage.initializeTimeSheetsSummaryReportTable();
        return tspwmcrPage.getTimeSheetsSummaryReportTable();
    }

}
