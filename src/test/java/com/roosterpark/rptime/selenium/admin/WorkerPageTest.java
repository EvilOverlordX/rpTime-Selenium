package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.control.complex.list.WorkerEditList;
import com.roosterpark.rptime.selenium.control.complex.list.WorkerEditListRow;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.WorkerPage;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * User: John
 * Date: 10/28/13
 * Time: 1:57 PM
 */
public class WorkerPageTest extends BasicSeleniumTest {

    private static final String FIRST_NAME = "foo-" + System.currentTimeMillis();
    private static final String SALARIED_FIRST_NAME = "s-" + FIRST_NAME;
    private static final String HOURLY_FIRST_NAME = "h-" + FIRST_NAME;
    private static final String LAST_NAME = "bar-" + System.currentTimeMillis();
    private static final String EMAIL = "foobar-" + System.currentTimeMillis() + "@roosterpark.com";
    private static final String SALARIED_EMAIL = "s-" + EMAIL;
    private static final String HOURLY_EMAIL = "h-" + EMAIL;
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
        workerFormHelper(HOURLY_FIRST_NAME, LAST_NAME, HOURLY_EMAIL, START_DATE, true);
        workerPage.waitForWorkersRedraw();
        workerPage.initWorkerEditList();
        verifyWorkerAdded(workerPage, HOURLY_EMAIL);
        workerPage.close();
    }

    @Test
    public void addSalariedWorkerTest() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getAdminNavBar();
        WorkerPage workerPage = navBar.clickWorkersLink();
        workerPage.initWorkerForm();
        workerForm = workerPage.getCreateWorkerForm();
        workerFormHelper(SALARIED_FIRST_NAME, LAST_NAME, SALARIED_EMAIL, START_DATE, false);
        workerPage.waitForWorkersRedraw();
        workerPage.initWorkerEditList();
        verifyWorkerAdded(workerPage, SALARIED_EMAIL);
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

    private void verifyWorkerAdded(WorkerPage workerPage, String email) {
        WorkerEditList workerEditList = workerPage.getWorkerEditList();
        WorkerEditListRow row = workerEditList.getRowByEmail(email);
        assertNotNull("Worker not added!", row);
    }

}
