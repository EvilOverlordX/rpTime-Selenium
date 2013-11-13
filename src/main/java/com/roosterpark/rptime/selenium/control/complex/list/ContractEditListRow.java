package com.roosterpark.rptime.selenium.control.complex.list;

/**
 * User: John
 * Date: 11/13/13
 * Time: 11:50 AM
 */
public class ContractEditListRow {

    private EditButton editButton;
    private String client;
    private String worker;
    private String startDate;
    private String endDate;

    public ContractEditListRow(EditButton editButton, String client, String worker, String startDate, String endDate) {
        this.editButton = editButton;
        this.client = client;
        this.worker = worker;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void clickEditButton() {
        editButton.click();
    }

    public String getClient() {
        return client;
    }

    public String getWorker() {
        return worker;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractEditListRow that = (ContractEditListRow) o;

        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (editButton != null ? !editButton.equals(that.editButton) : that.editButton != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (worker != null ? !worker.equals(that.worker) : that.worker != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = editButton != null ? editButton.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (worker != null ? worker.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContractEditListRow{" +
                "editButton=" + editButton +
                ", client='" + client + '\'' +
                ", worker='" + worker + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

}
