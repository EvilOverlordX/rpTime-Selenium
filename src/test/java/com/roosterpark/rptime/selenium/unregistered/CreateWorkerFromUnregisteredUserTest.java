package com.roosterpark.rptime.selenium.unregistered;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.control.complex.list.unregistered.UnregisteredUserLink;
import com.roosterpark.rptime.selenium.control.complex.list.unregistered.UnregisteredWorkerList;
import com.roosterpark.rptime.selenium.control.complex.list.unregistered.UnregisteredWorkerListRow;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerEditList;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.ErrorPage;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import com.roosterpark.rptime.selenium.page.admin.WorkerPage;
import com.roosterpark.rptime.selenium.user.TestUser;
import com.roosterpark.rptime.selenium.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: John
 * Date: 1/6/14
 * Time: 9:52 AM
 */
public class CreateWorkerFromUnregisteredUserTest extends BasicSeleniumTest {

    private static final String EMAIL = "testuser2@roosterpark.com";
    private static final String PASSWORD = "te5tU5er2";

    private LoginMule loginMule;
    private User user;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
        user = new TestUser(EMAIL, PASSWORD);
    }

    @Test
    public void createWorkerFromUnregisteredUserTest() {
        doErrorLogin();
        UnregisteredWorkerListRow row = checkForUnregisteredUser();
        UnregisteredUserLink link = row.getUnregisteredUserLink();
        enterUserInfo(link.click());
        WorkerPage workerPage = new WorkerPage(getDriver());
        workerPage.pauseForRedraw();
        workerPage.initWorkerEditList();
        WorkerEditList editList = workerPage.getWorkerEditList();
        assertNotNull("Worker not added!", editList.getRowByEmail(EMAIL));
        workerPage.close();
    }

    private void doErrorLogin() {
        ErrorPage errorPage = loginMule.errorLoginAsTestDefinedUser(user);
        errorPage.pauseForRedraw();
        assertEquals("Error code incorrect!", "403", errorPage.getErrorCode());
        assertEquals("Error message incorrect!", "FORBIDDEN", errorPage.getErrorMessage());
        assertTrue("Username not in resolution text!", errorPage.getResolutionText().contains(EMAIL));
        errorPage.clickSignOutButton();
    }

    private UnregisteredWorkerListRow checkForUnregisteredUser() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getNavBar();
        WorkerPage workerPage = navBar.clickWorkersLink();
        workerPage.pauseForRedraw();
        workerPage.initUnregisteredWorkerList();
        UnregisteredWorkerList list = workerPage.getUnregisteredWorkerList();
        assertNotNull("Worker not present!", list.getRowByEmail(EMAIL));
        return list.getRowByEmail(EMAIL);
    }

    private void enterUserInfo(CreateWorkerForm form) {
        assertTrue("Email not set as default!", form.doesEmailFieldHaveText());
        form.enterFirstName("Aiko");
        form.enterLastName("Doe");
        form.enterStartDate("2014-01-01");
        form.clickSave();
    }

}
