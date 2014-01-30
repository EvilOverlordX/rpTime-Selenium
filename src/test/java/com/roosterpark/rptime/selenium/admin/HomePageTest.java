package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.admin.ClientPage;
import com.roosterpark.rptime.selenium.page.admin.ContractsPage;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import com.roosterpark.rptime.selenium.page.admin.WorkerPage;
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

}
