package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.BasicSeleniumTest;
import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerEditList;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerEditListRow;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.WorkerPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    private static final String BAD_FIRST = "Badfirst";
    private static final String BAD_LAST = "Badlast";
    private static final String BAD_EMAIL = "bademail@roosterpark.com";
    private static final String BAD_START_DATE = "2013-01-01";

    private LoginMule loginMule;
    private CreateWorkerForm workerForm;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
    }

    @Test
    public void addHourlyWorkerTest() {
        WorkerPage workerPage = goToWorkerPage();
        workerPage.initWorkerForm();
        workerForm = workerPage.getCreateWorkerForm();
        workerFormHelper(HOURLY_FIRST_NAME, LAST_NAME, HOURLY_EMAIL, START_DATE, true);
        workerPage.pauseForRedraw();
        workerPage.initWorkerEditList();
        verifyWorkerAdded(workerPage, HOURLY_EMAIL);
        workerPage.close();
    }

    @Test
    public void addSalariedWorkerTest() {
        WorkerPage workerPage = goToWorkerPage();
        workerPage.initWorkerForm();
        workerForm = workerPage.getCreateWorkerForm();
        workerFormHelper(SALARIED_FIRST_NAME, LAST_NAME, SALARIED_EMAIL, START_DATE, false);
        workerPage.pauseForRedraw();
        workerPage.initWorkerEditList();
        verifyWorkerAdded(workerPage, SALARIED_EMAIL);
        workerPage.close();
    }

    @Test
    public void noFirstNameWorkerTest() {
        WorkerPage workerPage = goToWorkerPage();
        workerPage.initWorkerForm();
        workerForm = workerPage.getCreateWorkerForm();
        workerForm.enterLastName(BAD_LAST);
        workerForm.enterEmail(BAD_EMAIL);
        workerForm.enterStartDate(BAD_START_DATE);
        workerForm.clickSave();
        assertTrue("Worker form not here!", workerForm.doesLastNameHaveText());
        assertTrue("Worker form not here!", workerForm.doesEmailFieldHaveText());
        workerPage.close();
    }

    @Test
    public void noLastNameWorkerTest() {
        WorkerPage workerPage = goToWorkerPage();
        workerPage.initWorkerForm();
        workerForm = workerPage.getCreateWorkerForm();
        workerForm.enterFirstName(BAD_FIRST);
        workerForm.enterEmail(BAD_EMAIL);
        workerForm.enterStartDate(BAD_START_DATE);
        workerForm.clickSave();
        assertTrue("Worker form not here!", workerForm.doesFirstNameHaveText());
        assertTrue("Worker form not here!", workerForm.doesEmailFieldHaveText());
        workerPage.close();
    }

    @Test
    public void noEmailWorkerTest() {
        WorkerPage workerPage = goToWorkerPage();
        workerPage.initWorkerForm();
        workerForm = workerPage.getCreateWorkerForm();
        workerForm.enterFirstName(BAD_FIRST);
        workerForm.enterLastName(BAD_LAST);
        workerForm.enterStartDate(BAD_START_DATE);
        workerForm.clickSave();
        assertTrue("Worker form not here!", workerForm.doesFirstNameHaveText());
        assertTrue("Worker form not here!", workerForm.doesLastNameHaveText());
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

    private WorkerPage goToWorkerPage() {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getNavBar();
        WorkerPage workerPage = navBar.clickWorkersLink();
        workerPage.pauseForRedraw();
        return workerPage;
    }

}
