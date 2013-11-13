package com.roosterpark.rptime.selenium.control.complex.list.client;

import com.roosterpark.rptime.selenium.control.complex.list.generator.ClientEditListRowGenerator;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 11/12/13
 * Time: 1:44 PM
 */
public class ClientEditList {

    private WebDriver driver;
    private List<ClientEditListRow> rows;
    private Map<String, ClientEditListRow> rowsByName;
    private ClientEditListRowGenerator generator;

    public ClientEditList(WebDriver driver) {
        this.driver = driver;
        rowsByName = new HashMap<>();
        generator = new ClientEditListRowGenerator(driver);
    }

    public void init() {
        rows = generator.generate();
        for (ClientEditListRow row : rows) {
            rowsByName.put(row.getName(), row);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public List<ClientEditListRow> getRows() {
        return rows;
    }

    public ClientEditListRow getRowByName(String name) {
        return rowsByName.get(name);
    }

}
