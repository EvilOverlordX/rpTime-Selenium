package com.roosterpark.rptime.selenium.admin.reports;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.navbar.ReportsPopup;
import com.roosterpark.rptime.selenium.control.complex.reports.TotalHoursReportTable;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import com.roosterpark.rptime.selenium.page.admin.HoursPerWorkerMonthReportPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: John
 * Date: 2/13/14
 * Time: 3:16 PM
 */
public class EmptyHoursPerWorkerMonthReportTest extends BasicSeleniumTest {

    private LoginMule loginMule;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void emptyReportTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        ReportsPopup popup = homePage.getNavBar().clickReportDropDown();
        HoursPerWorkerMonthReportPage hoursPerWorkerMonthReportPage = popup.clickHoursPerWorkerMonthReportLink();
        hoursPerWorkerMonthReportPage.pauseForRedraw();
        hoursPerWorkerMonthReportPage.initializeTotalHoursReportTable();
        TotalHoursReportTable table = hoursPerWorkerMonthReportPage.getTotalHoursReportTable();
        assertEquals("Total hours incorrect!", Double.valueOf(0.00), table.getTotalHours());
        assertEquals("Total workers incorrect!", Integer.valueOf(0), table.getTotalWorkers());
        hoursPerWorkerMonthReportPage.close();
    }

}
