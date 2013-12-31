package com.roosterpark.rptime.selenium.control.complex.list.unregistered;

import com.roosterpark.rptime.selenium.control.complex.list.generator.UnregisteredWorkerListRowGenerator;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 12/31/13
 * Time: 9:22 AM
 */
public class UnregisteredWorkerList {

    private List<UnregisteredWorkerListRow> rows;
    private Map<String, UnregisteredWorkerListRow> rowsByEmail;
    private WebDriver driver;

    public UnregisteredWorkerList(WebDriver driver) {
        this.driver = driver;
        rowsByEmail = new HashMap<>();
    }

    public void initialize() {
        UnregisteredWorkerListRowGenerator generator = new UnregisteredWorkerListRowGenerator(driver);
        rows = generator.generate();
        for (UnregisteredWorkerListRow row: rows) {
            rowsByEmail.put(row.getEmail(), row);
        }
    }

    public List<UnregisteredWorkerListRow> getAllRows() {
        return rows;
    }

    public UnregisteredWorkerListRow getRowByEmail(String email) {
        return rowsByEmail.get(email);
    }

}
