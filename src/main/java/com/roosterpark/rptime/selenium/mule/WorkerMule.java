package com.roosterpark.rptime.selenium.mule;

import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.control.complex.navbar.AdminNavBar;
import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.WorkerPage;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/28/13
 * Time: 2:01 PM
 */
public class WorkerMule {

    private WebDriver driver;

    private LoginMule loginMule;

    public WorkerMule(WebDriver driver) {
        this.driver = driver;
        loginMule = new LoginMule(this.driver);
    }

    public WorkerPage addHourlyWorker(String firstName, String lastName, String email, String startDate) {
        return addWorker(firstName, lastName, email, startDate, true);
    }

    public WorkerPage addSalariedWorker(String firstName, String lastName, String email, String startDate) {
        return addWorker(firstName, lastName, email, startDate, false);
    }

    private WorkerPage addWorker(String firstName, String lastName, String email, String startDate, boolean isHourly) {
        HomePage homePage = loginMule.loginAsAdmin();
        AdminNavBar navBar = homePage.getAdminNavBar();
        WorkerPage workerPage = navBar.clickWorkersLink();
        workerPage.initWorkerForm();
        CreateWorkerForm workerForm = workerPage.getCreateWorkerForm();
        workerForm.enterFirstName(firstName);
        workerForm.enterLastName(lastName);
        workerForm.enterEmail(email);
        workerForm.enterStartDate(startDate);
        if (isHourly) {
            workerForm.checkHourly();
        }
        workerForm.clickSave();
        return workerPage;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
