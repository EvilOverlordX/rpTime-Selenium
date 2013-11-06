package com.roosterpark.rptime.selenium.control.complex.list;

import com.roosterpark.rptime.selenium.control.complex.list.generator.WorkerEditListRowGenerator;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 11/6/13
 * Time: 3:05 PM
 */
public class WorkerEditList {

    private WebDriver driver;
    private List<WorkerEditListRow> rows;
    private Map<String, WorkerEditListRow> rowsByName;
    private Map<String, WorkerEditListRow> rowsByEmail;
    private WorkerEditListRowGenerator generator;

    public WorkerEditList(WebDriver driver) {
        this.driver = driver;
        rowsByEmail = new HashMap<>();
        rowsByName = new HashMap<>();
        generator = new WorkerEditListRowGenerator(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void init() {
        rows = generator.generate();
        for (WorkerEditListRow row : rows) {
            rowsByEmail.put(row.getEmail(), row);
            rowsByName.put(row.getName(), row);
        }
    }

    public List<WorkerEditListRow> getRows() {
        return rows;
    }

    public WorkerEditListRow getRowByEmail(String email) {
        return rowsByEmail.get(email);
    }

    public WorkerEditListRow getRowByName(String name) {
        return rowsByName.get(name);
    }

    public void clickEditByEmail(String email) {
        getRowByEmail(email).clickEditButton();
    }

    public void clickEditByName(String name) {
        getRowByName(name).clickEditButton();
    }

}
