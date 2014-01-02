package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateContractForm;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditList;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditListRow;
import com.roosterpark.rptime.selenium.mule.ClientMule;
import com.roosterpark.rptime.selenium.mule.WorkerMule;
import com.roosterpark.rptime.selenium.page.ClientPage;
import com.roosterpark.rptime.selenium.page.ContractsPage;
import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.WorkerPage;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: John
 * Date: 11/14/13
 * Time: 2:20 PM
 */
public class ContractsPageTest extends BasicSeleniumTest {

    private static final String WORKER_FIRST_NAME = "c-first" + System.currentTimeMillis();
    private static final String WORKER_LAST_NAME = "c-last-" + System.currentTimeMillis();
    private static final String EMAIL = WORKER_FIRST_NAME + "@roosterpark.com";
    private static final String START_DATE = "2014-01-01";
    private static final String END_DATE = "2014-12-31";
    private static final String CLIENT = "client-" + System.currentTimeMillis();
    private static final String CLIENT2 = "client2-" + System.currentTimeMillis();

    private WorkerMule workerMule;
    private ClientMule clientMule;

    @Before
    public void setup() {
        workerMule = new WorkerMule(getDriver());
        clientMule = new ClientMule(getDriver());
    }

    @Test
    public void onSiteContractTest() {
        workerMule.login();
        WorkerPage workerPage = workerMule.addSalariedWorker(WORKER_FIRST_NAME, WORKER_LAST_NAME, EMAIL, START_DATE);
        clientMule.setHomePage(workerPage.getNavBar().clickHomeLink());
        ClientPage clientPage = clientMule.addNonLunchRequiredClient(CLIENT, "Monday");
        HomePage homePage = clientPage.getNavBar().clickHomeLink();
        ContractsPage contractsPage = homePage.getNavBar().clickContractsLink();
        contractsPage.waitForContractsRedraw();
        contractsPage = createContractHelper(contractsPage, CLIENT, WORKER_LAST_NAME + ", " + WORKER_FIRST_NAME,
                                             true, START_DATE, END_DATE);
        verifyContractAdded(contractsPage, CLIENT);
        contractsPage.close();
    }

    @Test
    public void offSiteContractTest() {
        workerMule.login();
        WorkerPage workerPage = workerMule.addSalariedWorker(WORKER_FIRST_NAME, WORKER_LAST_NAME, EMAIL, START_DATE);
        clientMule.setHomePage(workerPage.getNavBar().clickHomeLink());
        ClientPage clientPage = clientMule.addNonLunchRequiredClient(CLIENT2, "Monday");
        HomePage homePage = clientPage.getNavBar().clickHomeLink();
        ContractsPage contractsPage = homePage.getNavBar().clickContractsLink();
        contractsPage.waitForContractsRedraw();
        contractsPage = createContractHelper(contractsPage, CLIENT2, WORKER_LAST_NAME + ", " + WORKER_FIRST_NAME,
                false, START_DATE, END_DATE);
        verifyContractAdded(contractsPage, CLIENT2);
        contractsPage.close();
    }

    private ContractsPage createContractHelper(ContractsPage contractsPage, String client, String worker,
                                               boolean isOnSite, String startDate, String endDate) {
        CreateContractForm createContractForm = contractsPage.getCreateContractForm();
        if (isOnSite) {
            createContractForm.checkOnSite();
        }
        createContractForm.selectClient(client);
        createContractForm.selectWorker(worker);
        createContractForm.enterStartDate(startDate);
        createContractForm.enterEndDate(endDate);
        createContractForm.clickSave();
        return contractsPage;
    }

    private void verifyContractAdded(ContractsPage contractsPage, String client) {
        contractsPage.waitForContractsRedraw();
        contractsPage.initContractEditList();
        ContractEditList contractEditList = contractsPage.getContractEditList();
        contractEditList.waitForContractsRedraw();
        List<ContractEditListRow> rows = contractEditList.getRowsByClient(client);
        assertEquals("Row count incorrect!", 1, rows.size());
        assertNotNull("Row null!", rows.get(0));
    }

}
