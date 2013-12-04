package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.TextField;
import com.roosterpark.rptime.selenium.exception.InoperableControlException;
import org.openqa.selenium.WebElement;

import java.util.UUID;

/**
 * User: John
 * Date: 11/27/13
 * Time: 2:34 PM
 */
public class TimeSheetSubRow {

    private boolean isDeletable = false;
    private boolean isAbleToAdd = true;
    private boolean isWeekendVisible = false;
    private boolean isWeekend = false;
    private TimeSheetRow homeRow;
    private TextField clockIn;
    private TextField clockOut;
    private AddButton addButton;
    private RemoveButton removeButton;
    private ClientDropDownButton clientDropDownButton;
    private UUID id;
    private int index = 0;
    private WebElement buttonsElement;

    public TimeSheetSubRow(TextField clockIn, TextField clockOut, AddButton addButton,
                           RemoveButton removeButton, ClientDropDownButton clientDropDownButton) {
        this.id = UUID.randomUUID();
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.addButton = addButton;
        this.removeButton = removeButton;
        this.clientDropDownButton = clientDropDownButton;
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
        if (isWeekend && !isWeekendVisible) {
            throw new InoperableControlException("Cannot select client at this time");
        }
        if(isDeletable) {
            removeButton.click();
            homeRow.removeSubRow(this.id);
        } else {
            throw new InoperableControlException("Cannot delete sub-row at this time");
        }
    }

    public void clickAddButton() {
        if (isWeekend && !isWeekendVisible) {
            throw new InoperableControlException("Cannot select client at this time");
        }
        if(isAbleToAdd) {
            addButton.click();
            this.isAbleToAdd = false;
            this.isDeletable = false;
            homeRow.generateNewSubRow(index);
        } else {
            throw new InoperableControlException("Cannot add new sub-row at this time");
        }
    }

    public void writeClockInTime(String time) {
        clockIn.enterText(time);
        if (isWeekend) {
            isWeekendVisible = true;
        }
    }

    public void clearClockInTime() {
        clockIn.clear();
        if (isWeekend && !areButtonsVisible()) {
            isWeekendVisible = false;
        }
    }

    public void writeClockOutTime(String time) {
        clockOut.enterText(time);
        if (isWeekend) {
            isWeekendVisible = true;
        }
    }

    public void clearClockOutTime() {
        clockOut.clear();
        if (isWeekend && !areButtonsVisible()) {
            isWeekendVisible = false;
        }
    }

    public ClientDropDownPopup clickClientDropDownButton() {
        if (isWeekend && !isWeekendVisible) {
            throw new InoperableControlException("Cannot select client at this time");
        }
        return clientDropDownButton.click();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setWeekendVisible(boolean isVisible) {
        isWeekendVisible = isVisible;
    }

    public boolean isWeekendVisible() {
        return isWeekendVisible;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setButtonsElement(WebElement element) {
        buttonsElement = element;
    }

    public boolean areButtonsVisible() {
        return !buttonsElement.getAttribute("class").contains("ng-hide");
    }

}
