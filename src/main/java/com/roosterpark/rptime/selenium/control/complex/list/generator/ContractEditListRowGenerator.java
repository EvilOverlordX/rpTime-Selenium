package com.roosterpark.rptime.selenium.control.complex.list.generator;

import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractEditListRow;
import com.roosterpark.rptime.selenium.control.complex.list.contract.ContractLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

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
        getElements();
        for (WebElement element : elements) {
            String clientName = getClientFromElement(element);
            List<WebElement> filteredElements = getListItemElements(element);
            for (WebElement filteredElement : filteredElements) {
                ContractLink contractLink = new ContractLink(driver, getIdFromElement(filteredElement));
                ContractEditListRow contractEditListRow = new ContractEditListRow(contractLink,
                                                                                  getStartDate(filteredElement),
                                                                                  getEndDate(filteredElement));
                contractEditListRow.setClient(clientName);
                contractEditListRow.setWorker(getWorker(filteredElement));
                rows.add(contractEditListRow);
            }
        }
        return rows;
    }

    private void getElements() {
        WebElement contractsDiv = driver.findElement(By.id("contracts"));
        elements = contractsDiv.findElements(By.xpath(".//div/div/ul/li"));
    }

    private List<WebElement> getListItemElements(WebElement element) {
        List<WebElement> filtered = new LinkedList<>();
        List<WebElement> unfiltered = element.findElements(By.xpath(".//ul/li"));
        for (WebElement unfilteredElement : unfiltered) {
            if (unfilteredElement.getAttribute("class").contains("ng-hide")) {
                // Do nothing here
            } else {
                filtered.add(unfilteredElement);
            }
        }
        return filtered;
    }

    private String getClientFromElement(WebElement element) {
        return element.getAttribute("id");
    }

    private String getIdFromElement(WebElement element) {
        WebElement link = element.findElement(By.xpath(".//a"));
        return link.getAttribute("id");
    }

    private String getWorker(WebElement element) {
        String baseText = element.getText().trim();
        String[] parts = baseText.split(" ");
        return parts[0] + " " + parts[1];
    }

    private String getStartDate(WebElement element) {
        String baseText = element.getText().trim();
        String[] parts = baseText.split(" ");
        return parts[3];
    }

    private String getEndDate(WebElement element) {
        String baseText = element.getText().trim();
        String[] parts = baseText.split(" ");
        return parts[5];
    }

}
