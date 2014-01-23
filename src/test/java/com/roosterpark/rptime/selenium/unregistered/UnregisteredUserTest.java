package com.roosterpark.rptime.selenium.unregistered;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.list.unregistered.UnregisteredWorkerList;
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
 * Date: 12/31/13
 * Time: 1:48 PM
 */
public class UnregisteredUserTest extends BasicSeleniumTest {

    private static final String EMAIL = "error.user.42@gmail.com";
    private static final String PASSWORD = "3rr05_P@55wd";

    private LoginMule loginMule;
    private User user;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
        user = new TestUser(EMAIL, PASSWORD);
    }

    @Test
    public void unregisteredUserTest() {
        ErrorPage errorPage = loginMule.errorLoginAsTestDefinedUser(user);
        errorPage.pauseForRedraw();
        assertEquals("Error code incorrect!", "403", errorPage.getErrorCode());
        assertEquals("Error message incorrect!", "FORBIDDEN", errorPage.getErrorMessage());
        assertTrue("Username not in resolution text!", errorPage.getResolutionText().contains(EMAIL));
        errorPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getNavBar();
        WorkerPage workerPage = navBar.clickWorkersLink();
        workerPage.pauseForRedraw();
        workerPage.initUnregisteredWorkerList();
        UnregisteredWorkerList list = workerPage.getUnregisteredWorkerList();
        assertNotNull("Worker not present!", list.getRowByEmail(EMAIL));
        workerPage.close();
    }

}
