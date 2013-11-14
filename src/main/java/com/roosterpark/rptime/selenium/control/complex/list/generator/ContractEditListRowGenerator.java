package com.roosterpark.rptime.selenium.control.complex.list.generator;

import com.roosterpark.rptime.selenium.control.complex.list.EditButton;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditListRow;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 11/14/13
 * Time: 9:20 AM
 */
public class ContractEditListRowGenerator {

    private WebDriver driver;
    private List<WebElement> elements;
    private List<ContractEditListRow> rows;

    public ContractEditListRowGenerator(WebDriver driver) {
        this.driver = driver;
        rows = new LinkedList<>();
    }

    public List<ContractEditListRow> generate() {
        boolean found = false;
        getElements();
        for (WebElement element : elements) {
            if (element.findElements(By.xpath(".//span[@class='btn-group']/button")).size() != 0) {
                if (!found) {
                    WaitForVisible waitForVisible = new WaitForVisible(element);
                    waitForVisible.waitForVisible(60L, 100L);
                    EditButton editButton = new EditButton(driver, getEditButtonId(element));
                    Map<String, String> textParts = filterText(element);
                    rows.add(new ContractEditListRow(editButton, textParts.get("client"), textParts.get("worker"),
                                                     textParts.get("startDate"), textParts.get("endDate")));
                    found = true;
                } else {
                    EditButton editButton = new EditButton(driver, getEditButtonId(element));
                    Map<String, String> textParts = filterText(element);
                    rows.add(new ContractEditListRow(editButton, textParts.get("client"), textParts.get("worker"),
                                                     textParts.get("startDate"), textParts.get("endDate")));
                }
            }
        }
        return rows;
    }

    private void getElements() {
        elements = driver.findElements(By.className("ng-binding"));
    }

    private String getEditButtonId(WebElement element) {
        List<WebElement> buttons = element.findElements(By.xpath(".//span[@class='btn-group']/button"));
        for (WebElement button : buttons) {
            String id = button.getAttribute("id");
            if (id.startsWith("edit")) {
                return id;
            }
        }
        return null; // just in case...
    }

    private Map<String, String> filterText(WebElement element) {
        Map<String, String> textElements = new HashMap<>();
        String baseString = element.getText().substring(5); // Snip off "Edit" text
        String[] baseStringParts = baseString.split(","); // Split off client name
        textElements.put("client", baseStringParts[0].trim());
        String[] remainingParts = baseStringParts[1].trim().split(" ");
        textElements.put("worker", remainingParts[0] + " " + remainingParts[1]); // Worker name got split
        textElements.put("startDate", remainingParts[3]); // Skip 2, which is a dash
        textElements.put("endDate", remainingParts[5]); // Skip 4, which is a dash
        return textElements;
    }

}
