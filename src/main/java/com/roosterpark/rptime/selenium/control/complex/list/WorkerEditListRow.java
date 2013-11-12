package com.roosterpark.rptime.selenium.control.complex.list;

/**
 * User: John
 * Date: 10/30/13
 * Time: 2:31 PM
 */
public class WorkerEditListRow {

    private EditButton editButton;
    private String name;
    private String email;

    public WorkerEditListRow(EditButton editButton, String name, String email) {
        this.editButton = editButton;
        this.email = email;
        this.name = name;
    }

    public void clickEditButton() {
        editButton.click();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkerEditListRow that = (WorkerEditListRow) o;

        if (editButton != null ? !editButton.equals(that.editButton) : that.editButton != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = editButton != null ? editButton.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkerEditListRow{" +
                "editButton=" + editButton +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
