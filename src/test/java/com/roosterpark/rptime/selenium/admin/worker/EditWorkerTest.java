package com.roosterpark.rptime.selenium.admin.worker;

import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerEditList;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerEditListRow;
import com.roosterpark.rptime.selenium.control.complex.list.worker.WorkerLink;
import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.mule.WorkerMule;
import com.roosterpark.rptime.selenium.page.admin.HomePage;
import com.roosterpark.rptime.selenium.page.admin.WorkerPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: John
 * Date: 2/7/14
 * Time: 10:39 AM
 */
public class EditWorkerTest extends BasicWorkerTest {

    private static final long time = System.currentTimeMillis();
    private static final String FIRST = "Basic" + time;
    private static final String LAST = "Worker" + time;
    private static final String EMAIL = "basicworker" + time + "@roosterpark.com";
    private static final String START_DATE = "2013-01-01";
    private static final String NEW_FIRST = "Advanced" + time;
    private static final String NEW_LAST = "Admin" + time;
    private static final String EMAIL2 = "basicadmin" + time + "@roosterpark.com";

    private WorkerMule workerMule;
    private LoginMule loginMule;

    @Before
    public void setup() {
        workerMule = new WorkerMule(getDriver());
        loginMule = new LoginMule(getDriver());
    }

    @Test
     public void editFirstNameTest() {
        CreateWorkerForm workerForm = setupToEdit(EMAIL);
        workerForm.clearFirstName();
        workerForm.enterFirstName(NEW_FIRST);
        workerForm.clickSave();
        WorkerPage workerPage = new WorkerPage(getDriver());
        workerPage.pauseForRedraw();
        WorkerEditList workerEditList = getWorkerEditList(workerPage);
        WorkerEditListRow row = workerEditList.getRowByEmail(EMAIL);
        WorkerLink workerLink = row.getWorkerLink();
        String[] parts = workerLink.getLinkText().trim().split(" ");
        assertEquals("First name not changed!", parts[1], NEW_FIRST);
        workerPage.close();
    }

    @Test
    public void editLastNameTest() {
        CreateWorkerForm workerForm = setupToEdit(EMAIL2);
        workerForm.clearLastName();
        workerForm.enterLastName(NEW_LAST);
        workerForm.clickSave();
        WorkerPage workerPage = new WorkerPage(getDriver());
        workerPage.pauseForRedraw();
        WorkerEditList workerEditList = getWorkerEditList(workerPage);
        WorkerEditListRow row = workerEditList.getRowByEmail(EMAIL2);
        WorkerLink workerLink = row.getWorkerLink();
        String[] parts = workerLink.getLinkText().trim().split(" ");
        String last = parts[0].substring(0, parts[0].length() - 1);
        assertEquals("Last name not changed!", last, NEW_LAST);
        workerPage.close();
    }

    private WorkerPage createWorker(String email) {
        workerMule.login();
        WorkerPage workerPage = workerMule.addSalariedWorker(FIRST, LAST, email, START_DATE);
        verifyWorkerAdded(workerPage, email);
        return workerPage;
    }

    private WorkerEditList getWorkerEditList(WorkerPage workerPage) {
        workerPage.pauseForRedraw();
        workerPage.initWorkerEditList();
        return workerPage.getWorkerEditList();
    }

    private WorkerPage editWorkerHelper(WorkerPage workerPage, String email) {
        WorkerEditList workerEditList = getWorkerEditList(workerPage);
        WorkerEditListRow row = workerEditList.getRowByEmail(email);
        return row.clickWorkerLink();
    }

    private CreateWorkerForm getEditWorkerForm(WorkerPage workerPage) {
        workerPage.pauseForRedraw();
        workerPage.initWorkerForm();
        return workerPage.getEditWorkerForm();
    }

    private CreateWorkerForm setupToEdit(String email) {
        WorkerPage workerPage = createWorker(email);
        workerPage.clickSignOutButton();
        HomePage homePage = loginMule.loginAsAdmin();
        workerPage = editWorkerHelper(homePage.getNavBar().clickWorkersLink(), email);
        return getEditWorkerForm(workerPage);
    }

}
