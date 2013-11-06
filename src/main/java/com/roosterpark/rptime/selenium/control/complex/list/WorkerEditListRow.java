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
}
