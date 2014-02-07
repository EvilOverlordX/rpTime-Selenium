package com.roosterpark.rptime.selenium.admin.contracts;

import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditList;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditListRow;
import com.roosterpark.rptime.selenium.mule.ClientMule;
import com.roosterpark.rptime.selenium.mule.WorkerMule;
import com.roosterpark.rptime.selenium.page.admin.ClientPage;
import com.roosterpark.rptime.selenium.page.admin.ContractsPage;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import com.roosterpark.rptime.selenium.page.admin.WorkerPage;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: John
 * Date: 1/13/14
 * Time: 12:33 PM
 */
public class ExpiredContractTest extends BasicContractsTest {

    private static final String CONTRACT_START_DATE = "2013-01-01";
    private static final String CONTRACT_END_DATE = "2013-12-31";
    private static final String WORKER_START_DATE = "2013-01-01";
    private static final String EMAIL_BASE = "@roosterpark.com";
    private static final String FIRST_NAME_BASE = "first-";
    private static final String LAST_NAME_BASE = "last-";
    private static final String CLIENT_BASE = "client-";

    private WorkerMule workerMule;
    private ClientMule clientMule;

    private String firstName;
    private String lastName;
    private String email;
    private String client;

    @Before
    public void setup() {
        workerMule = new WorkerMule(getDriver());
        clientMule = new ClientMule(getDriver());
        long time = System.currentTimeMillis();
        firstName = FIRST_NAME_BASE + time;
        lastName = LAST_NAME_BASE + time;
        email = firstName + EMAIL_BASE;
        client = CLIENT_BASE + time;
    }

    @Test
    public void expiredContractTest() {
        workerMule.login();
        WorkerPage workerPage = workerMule.addSalariedWorker(firstName, lastName, email, WORKER_START_DATE);
        clientMule.setHomePage(workerPage.getNavBar().clickHomeLink());
        ClientPage clientPage = clientMule.addNonLunchRequiredClient(client, "Monday");
        HomePage homePage = clientPage.getNavBar().clickHomeLink();
        ContractsPage contractsPage = homePage.getNavBar().clickContractsLink();
        contractsPage.pauseForRedraw();
        contractsPage = createContractHelper(contractsPage, client, lastName + ", " + firstName, true,
                                             CONTRACT_START_DATE, CONTRACT_END_DATE);
        contractsPage.pauseForRedraw();
        contractsPage.checkShowExpiredContracts();
        contractsPage.pauseForRedraw();
        contractsPage.initContractEditList();
        ContractEditList list = contractsPage.getContractEditList();
        list.waitForContractsRedraw();
        List<ContractEditListRow> rows = list.getRowsByClient(client);
        assertEquals("Row count incorrect!", 1, rows.size());
        assertNotNull("Row null!", rows.get(0));
        contractsPage.close();
    }

}
