package com.roosterpark.rptime.selenium.control.complex.list.worker;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.WorkerPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/22/13
 * Time: 10:46 AM
 */
public class WorkerLink extends Link<WorkerPage> {

    private String id;

    public WorkerLink(WebDriver driver, String id) {
        super(driver, id);
        this.id = id;
    }

    @Override
    public WorkerPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new WorkerPage(getDriver());
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkerLink that = (WorkerLink) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WorkerLink{" +
                "id='" + id + '\'' +
                '}';
    }

}
