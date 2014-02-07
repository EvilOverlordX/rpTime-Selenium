package com.roosterpark.rptime.selenium.admin.contracts;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateContractForm;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditList;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditListRow;
import com.roosterpark.rptime.selenium.page.admin.ContractsPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: John
 * Date: 2/6/14
 * Time: 3:20 PM
 */
public abstract class BasicContractsTest extends BasicSeleniumTest {

    public ContractsPage createContractHelper(ContractsPage contractsPage, String client, String worker,
                                               boolean isOnSite, String startDate, String endDate) {
        CreateContractForm createContractForm = contractsPage.getCreateContractForm();
        createContractForm.waitForCreateContractRedraw();
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

    public void verifyContractAdded(ContractsPage contractsPage, String client) {
        contractsPage.pauseForRedraw();
        contractsPage.initContractEditList();
        ContractEditList contractEditList = contractsPage.getContractEditList();
        contractEditList.waitForContractsRedraw();
        List<ContractEditListRow> rows = contractEditList.getRowsByClient(client);
        assertEquals("Row count incorrect!", 1, rows.size());
        assertNotNull("Row null!", rows.get(0));
    }

}
