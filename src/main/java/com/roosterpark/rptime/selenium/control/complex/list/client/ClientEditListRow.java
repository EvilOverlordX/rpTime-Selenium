package com.roosterpark.rptime.selenium.control.complex.list.client;

import com.roosterpark.rptime.selenium.control.complex.list.EditButton;

/**
 * User: John
 * Date: 11/12/13
 * Time: 1:31 PM
 */
public class ClientEditListRow {

    private EditButton editButton;
    private String name;

    public ClientEditListRow(EditButton editButton, String name) {
        this.editButton = editButton;
        this.name = name;
    }

    public void clickEditButton() {
        editButton.click();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEditListRow that = (ClientEditListRow) o;

        if (editButton != null ? !editButton.equals(that.editButton) : that.editButton != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = editButton != null ? editButton.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientEditListRow{" +
                "editButton=" + editButton +
                ", name='" + name + '\'' +
                '}';
    }

}
