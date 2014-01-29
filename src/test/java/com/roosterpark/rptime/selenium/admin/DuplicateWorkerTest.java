package com.roosterpark.rptime.selenium.admin;

import com.roosterpark.rptime.selenium.page.admin.WorkerPage;
import org.junit.Test;

/**
 * User: John
 * Date: 1/28/14
 * Time: 1:52 PM
 */
public class DuplicateWorkerTest extends BasicWorkerTest {

    private static final String FIRST = "Foo";
    private static final String LAST1 = "Bar1";
    private static final String LAST2 = "Bar2";
    private static final String EMAIL = "foobar@roosterpark.com";
    private static final String DATE = "2013-01-01";

    // TODO: Fix card#265
    @Test
    public void duplicateWorkerTest() {
        WorkerPage workerPage = goToWorkerPage();
        workerPage.initWorkerForm();
        setWorkerForm(workerPage.getCreateWorkerForm());
        workerFormHelper(FIRST, LAST1, EMAIL, DATE, false);
        workerPage.pauseForRedraw();
        workerPage.initWorkerForm();
        setWorkerForm(workerPage.getCreateWorkerForm());
        workerFormHelper(FIRST, LAST2, EMAIL, DATE, false);
        // Need some checking here, once card #265 is fixed
    }

}
