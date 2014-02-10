package com.roosterpark.rptime.selenium.admin.clients;

import com.roosterpark.rptime.selenium.control.complex.form.CreateClientForm;
import com.roosterpark.rptime.selenium.control.complex.list.client.ClientEditList;
import com.roosterpark.rptime.selenium.control.complex.list.client.ClientEditListRow;
import com.roosterpark.rptime.selenium.mule.ClientMule;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.admin.ClientPage;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: John
 * Date: 2/10/14
 * Time: 9:31 AM
 */
public class EditClientTest extends BasicClientsTest {

    private static final String NAME = "fooclient4-" + System.currentTimeMillis();
    private static final String NAME2 = "Edited Client Name" + System.currentTimeMillis();

    private ClientMule clientMule;
    private LoginMule loginMule;

    @Before
    public void setup() {
        clientMule = new ClientMule(getDriver());
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void editClientNameTest() {
        ClientPage clientPage = createClient();
        clientPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        clientPage = homePage.getNavBar().clickClientsLink();
        CreateClientForm editForm = editClientByName(clientPage, NAME);
        editForm.clearName();
        editForm.enterName(NAME2);
        editForm.clickSave();
        clientPage.pauseForRedraw();
        clientPage.initClientEditList();
        ClientEditList clientEditList = clientPage.getClientEditList();
        assertNotNull("Client name not changed!", clientEditList.getRowByName(NAME2));
        clientPage.close();
    }

    // TODO: Uncomment once card #278 is fixed
    //@Test
    public void editLunchRequiredCheckboxTest() {
        ClientPage clientPage = createClient();
        clientPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        clientPage = homePage.getNavBar().clickClientsLink();
        CreateClientForm editForm = editClientByName(clientPage, NAME);
        editForm.checkLunchRequired();
        editForm.clickSave();
        clientPage.pauseForRedraw();
        clientPage.initClientEditList();
        ClientEditList clientEditList = clientPage.getClientEditList();
        ClientEditListRow row = clientEditList.getRowByName(NAME);
        clientPage = row.clickClientLink();
        clientPage.pauseForRedraw();
        editForm = clientPage.getEditClientForm();
        assertTrue("Lunch check box not checked!", editForm.isLunchChecked());
        clientPage.close();
    }

    // TODO: Uncomment once card #278 is fixed
    //@Test
    public void editStartDayOfWeekTest() {
        ClientPage clientPage = createClient();
        clientPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        clientPage = homePage.getNavBar().clickClientsLink();
        CreateClientForm editForm = editClientByName(clientPage, NAME);
        editForm.selectTuesday();
        editForm.clickSave();
        clientPage.pauseForRedraw();
        clientPage.initClientEditList();
        ClientEditList clientEditList = clientPage.getClientEditList();
        ClientEditListRow row = clientEditList.getRowByName(NAME);
        clientPage = row.clickClientLink();
        clientPage.pauseForRedraw();
        editForm = clientPage.getEditClientForm();
        assertEquals("Start day of week not changed!", "Tuesday", editForm.getSelectedDayText());
        clientPage.close();
    }

    @Test
    public void cancelEditTest() {
        ClientPage clientPage = createClient();
        clientPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        clientPage = homePage.getNavBar().clickClientsLink();
        CreateClientForm editForm = editClientByName(clientPage, NAME);
        editForm.clearName();
        editForm.enterName(NAME2);
        editForm.clickCancel();
        clientPage.pauseForRedraw();
        clientPage.initClientEditList();
        ClientEditList clientEditList = clientPage.getClientEditList();
        assertNotNull("Client name changed!", clientEditList.getRowByName(NAME));
        clientPage.close();
    }

    private ClientPage createClient() {
        clientMule.login();
        ClientPage clientPage = clientMule.addNonLunchRequiredClient(NAME, "Monday");
        verifyClientAdded(clientPage, NAME);
        return clientPage;
    }

    private CreateClientForm editClientByName(ClientPage clientPage, String name) {
        clientPage.pauseForRedraw();
        clientPage.initClientEditList();
        ClientEditList clientEditList = clientPage.getClientEditList();
        ClientEditListRow row = clientEditList.getRowByName(name);
        clientPage = row.clickClientLink();
        clientPage.pauseForRedraw();
        return clientPage.getEditClientForm();
    }

}
