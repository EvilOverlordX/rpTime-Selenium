package com.roosterpark.rptime.selenium.admin.contracts;

import com.roosterpark.rptime.selenium.mule.ClientMule;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.mule.WorkerMule;
import com.roosterpark.rptime.selenium.page.admin.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: John
 * Date: 2/6/14
 * Time: 3:11 PM
 */
public class AdminContractTest extends BasicContractsTest {

    private static final String ADMIN_FIRST_NAME = "Test";
    private static final String ADMIN_LAST_NAME = "Admin";
    private static final String EMAIL = "testadmin@roosterpark.com";
    private static final String START_DATE = "2013-01-01";
    private static final String CLIENT = "Admin Client";
    private static final String CONTRACT_START_DATE = "2014-01-01";
    private static final String CONTRACT_END_DATE = "2014-12-31";

    private WorkerMule workerMule;
    private ClientMule clientMule;
    private LoginMule loginMule;

    @Before
    public void setup() {
        workerMule = new WorkerMule(getDriver());
        clientMule = new ClientMule(getDriver());
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void adminContractTest() {
        HomePage homePage = setupWorkerClient();
        ContractsPage contractsPage = homePage.getNavBar().clickContractsLink();
        contractsPage.pauseForRedraw();
        contractsPage = createContractHelper(contractsPage, CLIENT, ADMIN_LAST_NAME + ", " + ADMIN_FIRST_NAME,
                true, CONTRACT_START_DATE, CONTRACT_END_DATE);
        verifyContractAdded(contractsPage, CLIENT);
        contractsPage.clickSignOutButton();
        homePage = loginMule.loginAsAdmin();
        MyTimeSheetsPage myTimeSheetsPage = homePage.getNavBar().clickMyTimeSheetsLink();
        assertTrue("Not on My Time Sheets Page!", myTimeSheetsPage.isMyTimeSheetsPage());
        myTimeSheetsPage.close();
    }

    private HomePage setupWorkerClient() {
        workerMule.login();
        WorkerPage workerPage = workerMule.addSalariedWorker(ADMIN_FIRST_NAME, ADMIN_LAST_NAME, EMAIL, START_DATE);
        clientMule.setHomePage(workerPage.getNavBar().clickHomeLink());
        ClientPage clientPage = clientMule.addNonLunchRequiredClient(CLIENT, "Monday");
        return clientPage.getNavBar().clickHomeLink();
    }

}
