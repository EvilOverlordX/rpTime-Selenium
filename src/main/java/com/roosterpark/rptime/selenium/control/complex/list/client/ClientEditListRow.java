package com.roosterpark.rptime.selenium.control.complex.list.client;

import com.roosterpark.rptime.selenium.page.admin.ClientPage;

/**
 * User: John
 * Date: 11/12/13
 * Time: 1:31 PM
 */
public class ClientEditListRow {

    private ClientLink clientLink;
    private String name;

    public ClientEditListRow(ClientLink clientLink, String name) {
        this.clientLink = clientLink;
        this.name = name;
    }

    public ClientPage clickClientLink() {
        return clientLink.click();
    }

    public ClientLink getClientLink() {
        return clientLink;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEditListRow that = (ClientEditListRow) o;

        if (clientLink != null ? !clientLink.equals(that.clientLink) : that.clientLink != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return clientLink != null ? clientLink.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ClientEditListRow{" +
                "clientLink=" + clientLink +
                '}';
    }

}
