package com.roosterpark.rptime.selenium.control.complex.list.worker;

import com.roosterpark.rptime.selenium.page.admin.WorkerPage;

/**
 * User: John
 * Date: 10/30/13
 * Time: 2:31 PM
 */
public class WorkerEditListRow {

    private WorkerLink workerLink;
    private String email;

    public WorkerEditListRow(WorkerLink workerLink, String email) {
        this.email = email;
        this.workerLink = workerLink;
    }

    public String getEmail() {
        return email;
    }

    public WorkerPage clickWorkerLink() {
        return workerLink.click();
    }

    public WorkerLink getWorkerLink() {
        return workerLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkerEditListRow that = (WorkerEditListRow) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (workerLink != null ? !workerLink.equals(that.workerLink) : that.workerLink != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workerLink != null ? workerLink.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkerEditListRow{" +
                "workerLink=" + workerLink +
                ", email='" + email + '\'' +
                '}';
    }

}
