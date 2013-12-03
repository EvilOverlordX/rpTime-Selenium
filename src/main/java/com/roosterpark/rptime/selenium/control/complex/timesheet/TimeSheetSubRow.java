package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.TextField;
import com.roosterpark.rptime.selenium.exception.InoperableControlException;

import java.util.UUID;

/**
 * User: John
 * Date: 11/27/13
 * Time: 2:34 PM
 */
public class TimeSheetSubRow {

    private boolean isDeletable = false;
    private boolean isAbleToAdd = true;
    private TimeSheetRow homeRow;
    private TextField clockIn;
    private TextField clockOut;
    private AddButton addButton;
    private RemoveButton removeButton;
    private UUID id;

    public TimeSheetSubRow(TextField clockIn, TextField clockOut, AddButton addButton, RemoveButton removeButton) {
        this.id = UUID.randomUUID();
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.addButton = addButton;
        this.removeButton = removeButton;
    }

    public void setHomeRow(TimeSheetRow homeRow) {
        this.homeRow = homeRow;
    }

    public TimeSheetRow getHomeRow() {
        return homeRow;
    }

    public void setDeletable(boolean isDeletable) {
        this.isDeletable = isDeletable;
    }

    public boolean isDeletable() {
        return isDeletable;
    }

    public void setAbleToAdd(boolean isAbleToAdd) {
        this.isAbleToAdd = isAbleToAdd;
    }

    public boolean isAbleToAdd() {
        return isAbleToAdd;
    }

    public UUID getId() {
        return id;
    }

    public void clickRemoveButton() {
        if(isDeletable) {
            removeButton.click();
            homeRow.removeSubRow(this.id);
        } else {
            throw new InoperableControlException("Cannot delete sub-row at this time");
        }
    }

    public void clickAddButton() {
        if(isAbleToAdd) {
            addButton.click();
            this.isAbleToAdd = false;
            this.isDeletable = false;
            homeRow.generateNewSubRow();
        } else {
            throw new InoperableControlException("Cannot add new sub-row at this time");
        }
    }

    public void writeClockInTime(String time) {
        clockIn.enterText(time);
    }

    public void clearClockInTime() {
        clockIn.clear();
    }

    public void writeClockOutTime(String time) {
        clockOut.enterText(time);
    }

    public void clearClockOutTime() {
        clockOut.clear();
    }

}
