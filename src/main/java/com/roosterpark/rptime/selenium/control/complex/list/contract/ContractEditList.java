package com.roosterpark.rptime.selenium.control.complex.list.contract;

import com.roosterpark.rptime.selenium.control.complex.list.generator.ContractEditListRowGenerator;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 11/14/13
 * Time: 10:42 AM
 */
public class ContractEditList {

    private WebDriver driver;
    private List<ContractEditListRow> rows;
    private Map<String, List<ContractEditListRow>> rowsByClient;
    private Map<String, List<ContractEditListRow>> rowsByWorker;
    private ContractEditListRowGenerator generator;

    public ContractEditList(WebDriver driver) {
        this.driver = driver;
        rowsByClient = new HashMap<>();
        rowsByWorker = new HashMap<>();
    }

    public void init() {
        rows = generator.generate();
        for (ContractEditListRow row : rows) {
            if (rowsByClient.containsKey(row.getClient())) {
                rowsByClient.get(row.getClient()).add(row);
            } else {
                rowsByClient.put(row.getClient(), new LinkedList<ContractEditListRow>());
                rowsByClient.get(row.getClient()).add(row);
            }

            if (rowsByWorker.containsKey(row.getWorker())) {
                rowsByWorker.get(row.getWorker()).add(row);
            } else {
                rowsByWorker.put(row.getWorker(), new LinkedList<ContractEditListRow>());
                rowsByWorker.get(row.getWorker()).add(row);
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public List<ContractEditListRow> getRows() {
        return rows;
    }

    public List<ContractEditListRow> getRowsByClient(String client) {
        return rowsByClient.get(client);
    }

    public List<ContractEditListRow> getRowsByWorker(String worker) {
        return rowsByWorker.get(worker);
    }

}
