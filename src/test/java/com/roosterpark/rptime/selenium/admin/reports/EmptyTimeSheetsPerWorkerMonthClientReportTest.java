package com.roosterpark.rptime.selenium.admin.reports;

import com.roosterpark.rptime.selenium.admin.clients.BasicClientsTest;
import com.roosterpark.rptime.selenium.control.complex.navbar.ReportsPopup;
import com.roosterpark.rptime.selenium.control.complex.reports.TimeSheetsSummaryReportTable;
import com.roosterpark.rptime.selenium.page.admin.ClientPage;
import com.roosterpark.rptime.selenium.page.admin.TimeSheetsPerWorkerMonthClientReportPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: John
 * Date: 2/17/14
 * Time: 2:29 PM
 */
public class EmptyTimeSheetsPerWorkerMonthClientReportTest extends BasicClientsTest {

    private String client;

    @Before
    public void setup() {
        client = "reportClient-" + System.currentTimeMillis();
    }

    @Test
    public void emptyTimeSheetsPerWorkerMonthClientReportTest() {
        ClientPage clientPage = createClient();
        ReportsPopup popup = clientPage.getNavBar().clickReportDropDown();
        TimeSheetsPerWorkerMonthClientReportPage tspwmcrPage = popup.clickTimeSheetsPerWorkerMonthClientReportLink();
        tspwmcrPage.pauseForRedraw();
        tspwmcrPage.selectClient(client);
        tspwmcrPage.pauseForRedraw();
        tspwmcrPage.initializeTimeSheetsSummaryReportTable();
        TimeSheetsSummaryReportTable table = tspwmcrPage.getTimeSheetsSummaryReportTable();
        assertEquals("Incorrect worker count!", Integer.valueOf(0), table.getTotalWorkers());
        tspwmcrPage.close();
    }

    private ClientPage createClient() {
        ClientPage clientPage = goToClientPage();
        clientFormHelper(clientPage, client, true);
        clientPage.waitForClientsRedraw();
        clientPage.initClientEditList();
        verifyClientAdded(clientPage, client);
        return clientPage;
    }

}
