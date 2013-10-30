package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.WorkerPage;
import org.junit.Before;
import org.junit.Test;

/**
 * User: John
 * Date: 10/28/13
 * Time: 1:57 PM
 */
public class WorkerPageTest extends BasicSeleniumTest {

    private static final String FIRST_NAME = "foo-" + System.currentTimeMillis();
    private static final String LAST_NAME = "bar-" + System.currentTimeMillis();
    private static final String EMAIL = "foobar-" + System.currentTimeMillis() + "@roosterpark.com";
    private static final String START_DATE = "2013-12-31";

    private LoginMule loginMule;
    private CreateWorkerForm workerForm;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void addHourlyWorkerTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getAdminNavBar();
        WorkerPage workerPage = navBar.clickWorkersLink();
        workerPage.initWorkerForm();
        workerForm = workerPage.getCreateWorkerForm();
        workerFormHelper(FIRST_NAME, LAST_NAME, EMAIL, START_DATE, true);
        //TODO: Add verification here once worker page is fixed.
        workerPage.close();
    }

    @Test
    public void addSalariedWorkerTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getAdminNavBar();
        WorkerPage workerPage = navBar.clickWorkersLink();
        workerPage.initWorkerForm();
        workerForm = workerPage.getCreateWorkerForm();
        workerFormHelper(FIRST_NAME, LAST_NAME, EMAIL, START_DATE, false);
        //TODO: Add verification here once worker page is fixed.
        workerPage.close();
    }

    private void workerFormHelper(String firstName, String lastName, String email, String startDate, boolean isHourly) {
        workerForm.enterFirstName(firstName);
        workerForm.enterLastName(lastName);
        workerForm.enterEmail(email);
        workerForm.enterStartDate(startDate);
        if (isHourly) {
            workerForm.checkHourly();
        }
        workerForm.clickSave();
    }

}
