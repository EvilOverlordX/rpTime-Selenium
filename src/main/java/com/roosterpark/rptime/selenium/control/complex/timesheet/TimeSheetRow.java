package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.complex.timesheet.generator.TimeSheetSubRowGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * User: John
 * Date: 12/2/13
 * Time: 2:19 PM
 */
public class TimeSheetRow {

    private Map<UUID, TimeSheetSubRow> subRows;
    private Map<Integer, TimeSheetSubRow> subRowsByIndex;
    private WebDriver driver;
    private WebElement element;
    private boolean isWeekend;

    public TimeSheetRow(WebDriver driver, WebElement element, boolean isWeekend) {
        this.driver = driver;
        this.element = element;
        subRows = new LinkedHashMap<>();
        subRowsByIndex = new LinkedHashMap<>();
        this.isWeekend = isWeekend;
    }

    public void initialize() {
        TimeSheetSubRowGenerator generator = new TimeSheetSubRowGenerator(driver, element, this);
        List<TimeSheetSubRow> listSubRows = generator.generate();
        for (TimeSheetSubRow subRow: listSubRows) {
            if (isWeekend) {
                subRow.setIsWeekend(true);
            }
            subRows.put(subRow.getId(), subRow);
            subRowsByIndex.put(subRow.getIndex(), subRow);
        }
    }

    public void removeSubRow(TimeSheetSubRow subRow) {
        subRows.remove(subRow.getId());
        subRowsByIndex.remove(subRow.getIndex());
    }

    public TimeSheetSubRow getSubRowById(UUID id) {
        return subRows.get(id);
    }

    public TimeSheetSubRow getSubRowByIndex(int index) {
        return subRowsByIndex.get(index);
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public int getSubRowCount() {
        return subRows.size();
    }

}
