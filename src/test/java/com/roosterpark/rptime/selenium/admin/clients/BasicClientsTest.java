package com.roosterpark.rptime.selenium.admin.clients;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateClientForm;
import com.roosterpark.rptime.selenium.control.complex.list.client.ClientEditList;
import com.roosterpark.rptime.selenium.control.complex.list.client.ClientEditListRow;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.admin.ClientPage;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import org.junit.Before;

import static org.junit.Assert.assertNotNull;

/**
 * User: John
 * Date: 2/10/14
 * Time: 9:00 AM
 */
public abstract class BasicClientsTest extends BasicSeleniumTest {

    private LoginMule loginMule;

    @Before
    public void setupClients() {
        loginMule = new LoginMule(getDriver());
    }

    public void clientFormHelper(ClientPage clientPage, String name, boolean isLunchRequired) {
        CreateClientForm createClientForm = clientPage.getCreateClientForm();
        createClientForm.enterName(name);
        if (isLunchRequired) {
            createClientForm.checkLunchRequired();
        }
        createClientForm.selectMonday();
        createClientForm.clickSave();
    }

    public void verifyClientAdded(ClientPage clientPage, String name) {
        ClientEditList clientEditList = clientPage.getClientEditList();
        ClientEditListRow row = clientEditList.getRowByName(name);
        assertNotNull("Client not added!", row);
    }

    public ClientPage goToClientPage() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getNavBar();
        ClientPage clientPage = navBar.clickClientsLink();
        clientPage.pauseForRedraw();
        return clientPage;
    }

}
