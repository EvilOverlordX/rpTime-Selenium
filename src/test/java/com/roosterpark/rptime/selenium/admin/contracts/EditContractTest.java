package com.roosterpark.rptime.selenium.admin.contracts;

import com.roosterpark.rptime.selenium.control.complex.form.CreateContractForm;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditList;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditListRow;
import com.roosterpark.rptime.selenium.mule.ContractsMule;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.admin.ContractsPage;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * User: John
 * Date: 2/11/14
 * Time: 12:24 PM
 */
public class EditContractTest extends BasicContractsTest {

    private static final String FIRST = "first-" + System.currentTimeMillis();
    private static final String LAST = "last-" + System.currentTimeMillis();
    private static final String EMAIL = "email-" + System.currentTimeMillis() + "@roosterpark.com";
    private static final String EMPLOYEE_START = "2013-01-01";
    private static final String DAY_OF_WEEK = "Monday";
    private static final String CONTRACT_START = "2014-01-01";
    private static final String CONTRACT_END = "2014-12-31";
    private static final String WORKER = LAST + ", " + FIRST;
    private static final String NEW_START = "2014-01-02";
    private static final String NEW_END = "2014-12-30";

    private ContractsMule contractsMule;
    private LoginMule loginMule;
    private String client;

    @Before
    public void setup() {
        contractsMule = new ContractsMule(getDriver());
        loginMule = new LoginMule(getDriver());
        client = "client-" + System.currentTimeMillis();
    }

    @Test
    public void editStartDateTest() {
        ContractsPage contractsPage = createContract();
        contractsPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        contractsPage = homePage.getNavBar().clickContractsLink();
        CreateContractForm editForm = getContractEditForm(contractsPage, WORKER);
        editForm.clearStartDate();
        editForm.enterStartDate(NEW_START);
        editForm.clickSave();
        editForm = getContractEditForm(contractsPage, WORKER);
        assertEquals("Dates don't match!", NEW_START, editForm.getStartDate());
        contractsPage.close();
    }

    @Test
    public void editEndDateTest() {
        ContractsPage contractsPage = createContract();
        contractsPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        contractsPage = homePage.getNavBar().clickContractsLink();
        CreateContractForm editForm = getContractEditForm(contractsPage, WORKER);
        editForm.clearEndDate();
        editForm.enterEndDate(NEW_END);
        editForm.clickSave();
        editForm = getContractEditForm(contractsPage, WORKER);
        assertEquals("Dates don't match!", NEW_END, editForm.getEndDate());
        contractsPage.close();
    }

    @Test
    public void editSiteTest() {
        ContractsPage contractsPage = createContract();
        contractsPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        contractsPage = homePage.getNavBar().clickContractsLink();
        CreateContractForm editForm = getContractEditForm(contractsPage, WORKER);
        editForm.checkOnSite();
        editForm.clickSave();
        editForm = getContractEditForm(contractsPage, WORKER);
        assertFalse("On site checked!", editForm.isOnSiteChecked());
        contractsPage.close();
    }

    private ContractsPage createContract() {
        contractsMule.login();
        contractsMule.addWorker(FIRST, LAST, EMAIL, EMPLOYEE_START, true);
        contractsMule.addClient(client, DAY_OF_WEEK, false);
        ContractsPage contractsPage = contractsMule.createOnSiteContract(client, WORKER, CONTRACT_START, CONTRACT_END);
        verifyContractAdded(contractsPage, client);
        return contractsPage;
    }

    private CreateContractForm getContractEditForm(ContractsPage contractsPage, String worker) {
        contractsPage.pauseForRedraw();
        contractsPage.initContractEditList();
        ContractEditList contractEditList = contractsPage.getContractEditList();
        ContractEditListRow row = contractEditList.getRowsByWorker(worker).get(0);
        contractsPage = row.clickContractsLink();
        contractsPage.pauseForRedraw();
        return contractsPage.getEditContractForm();
    }

}
