package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateClientForm;
import com.roosterpark.rptime.selenium.control.complex.list.client.ClientEditList;
import com.roosterpark.rptime.selenium.control.complex.list.client.ClientEditListRow;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.ClientPage;
import com.roosterpark.rptime.selenium.page.HomePage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: John
 * Date: 11/4/13
 * Time: 10:48 AM
 */
public class ClientsPageTest extends BasicSeleniumTest {

    private static final String NAME = "fooclient-" + System.currentTimeMillis();
    private static final String NAME2 = "fooclient2-" + System.currentTimeMillis();
    private static final String NAME3 = "fooclient3-" + System.currentTimeMillis();

    private LoginMule loginMule;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void addLunchRequiredClientTest() {
        ClientPage clientPage = goToClientPage();
        clientFormHelper(clientPage, NAME, true);
        clientPage.waitForClientsRedraw();
        clientPage.initClientEditList();
        verifyClientAdded(clientPage, NAME);
        clientPage.close();
    }

    @Test
    public void addNonLunchRequiredClientTest() {
        ClientPage clientPage = goToClientPage();
        clientFormHelper(clientPage, NAME2, true);
        clientPage.waitForClientsRedraw();
        clientPage.initClientEditList();
        verifyClientAdded(clientPage, NAME2);
        clientPage.close();
    }

    @Test
    public void noStartDayClientTest() {
        ClientPage clientPage = goToClientPage();
        CreateClientForm createClientForm = clientPage.getCreateClientForm();
        createClientForm.enterName(NAME3);
        createClientForm.clickSave();
        assertTrue("Create client form not here!", createClientForm.hasTextEntered());
        clientPage.close();
    }

    @Test
    public void noNameClientTest() {
        ClientPage clientPage = goToClientPage();
        CreateClientForm createClientForm = clientPage.getCreateClientForm();
        createClientForm.selectMonday();
        createClientForm.clickSave();
        assertEquals("Create client form not here!", "Monday", createClientForm.getSelectedDayText());
        clientPage.close();
    }

    private void clientFormHelper(ClientPage clientPage, String name, boolean isLunchRequired) {
        CreateClientForm createClientForm = clientPage.getCreateClientForm();
        createClientForm.enterName(name);
        if (isLunchRequired) {
            createClientForm.checkLunchRequired();
        }
        createClientForm.selectMonday();
        createClientForm.clickSave();
    }

    private void verifyClientAdded(ClientPage clientPage, String name) {
        ClientEditList clientEditList = clientPage.getClientEditList();
        ClientEditListRow row = clientEditList.getRowByName(name);
        assertNotNull("Client not added!", row);
    }

    private ClientPage goToClientPage() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getNavBar();
        ClientPage clientPage = navBar.clickClientsLink();
        clientPage.pauseForRedraw();
        return clientPage;
    }

}
