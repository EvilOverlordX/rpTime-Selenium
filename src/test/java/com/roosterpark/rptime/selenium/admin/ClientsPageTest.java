package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateClientForm;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.ClientPage;
import com.roosterpark.rptime.selenium.page.HomePage;
import org.junit.Before;
import org.junit.Test;

/**
 * User: John
 * Date: 11/4/13
 * Time: 10:48 AM
 */
public class ClientsPageTest extends BasicSeleniumTest {

    private static final String NAME = "fooclient-" + System.currentTimeMillis();

    private LoginMule loginMule;
    private CreateClientForm createClientForm;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void addLunchRequiredClientTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getAdminNavBar();
        ClientPage clientPage = navBar.clickClientsLink();
        clientPage.clickNewButton();
        createClientForm = clientPage.getCreateClientForm();
        createClientForm.enterName(NAME);
        createClientForm.checkLunchRequired();
        createClientForm.selectMonday();
        createClientForm.clickSave();
        //TODO: add verification
        clientPage.close();
    }

}
