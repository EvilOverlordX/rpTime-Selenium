package com.roosterpark.rptime.selenium.admin.clients;

import com.roosterpark.rptime.selenium.control.complex.form.CreateClientForm;
import com.roosterpark.rptime.selenium.page.admin.ClientPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: John
 * Date: 11/4/13
 * Time: 10:48 AM
 */
public class ClientsPageTest extends BasicClientsTest {

    private static final String NAME = "fooclient-" + System.currentTimeMillis();
    private static final String NAME2 = "fooclient2-" + System.currentTimeMillis();
    private static final String NAME3 = "fooclient3-" + System.currentTimeMillis();

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



}
