package com.roosterpark.rptime.selenium.control.complex.list.contract;

import com.roosterpark.rptime.selenium.page.admin.ContractsPage;

/**
 * User: John
 * Date: 11/13/13
 * Time: 11:50 AM
 */
public class ContractEditListRow {

    private String startDate;
    private String endDate;
    private ContractLink contractLink;
    private String worker;
    private String client;
    private ExpiredLabel expiredLabel;

    public ContractEditListRow(ContractLink contractLink, String startDate, String endDate, ExpiredLabel expiredLabel) {
        this.contractLink = contractLink;
        this.startDate = startDate;
        this.endDate = endDate;
        this.expiredLabel = expiredLabel;
    }

    public ContractsPage clickContractsLink() {
        return contractLink.click();
    }

    public ContractLink getContractLink() {
        return contractLink;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public boolean isExpired() {
        return expiredLabel.isVisible();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractEditListRow that = (ContractEditListRow) o;

        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (contractLink != null ? !contractLink.equals(that.contractLink) : that.contractLink != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (worker != null ? !worker.equals(that.worker) : that.worker != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (contractLink != null ? contractLink.hashCode() : 0);
        result = 31 * result + (worker != null ? worker.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContractEditListRow{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", contractLink=" + contractLink +
                ", worker='" + worker + '\'' +
                ", client='" + client + '\'' +
                '}';
    }

}
