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

import static org.junit.Assert.assertNotNull;

/**
 * User: John
 * Date: 11/4/13
 * Time: 10:48 AM
 */
public class ClientsPageTest extends BasicSeleniumTest {

    private static final String NAME = "fooclient-" + System.currentTimeMillis();

    private LoginMule loginMule;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void addLunchRequiredClientTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getNavBar();
        ClientPage clientPage = navBar.clickClientsLink();
        clientFormHelper(clientPage, NAME, true);
        clientPage.waitForClientsRedraw();
        clientPage.initClientEditList();
        verifyClientAdded(clientPage, NAME);
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

}
