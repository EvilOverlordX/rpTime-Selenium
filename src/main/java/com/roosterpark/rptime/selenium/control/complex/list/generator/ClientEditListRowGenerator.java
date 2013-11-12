package com.roosterpark.rptime.selenium.control.complex.list.generator;

import com.roosterpark.rptime.selenium.control.complex.list.ClientEditListRow;
import com.roosterpark.rptime.selenium.control.complex.list.EditButton;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 11/12/13
 * Time: 1:34 PM
 */
public class ClientEditListRowGenerator {

    private WebDriver driver;
    private List<WebElement> elements;
    private List<ClientEditListRow> rows;

    public ClientEditListRowGenerator(WebDriver driver) {
        this.driver = driver;
        rows = new LinkedList<>();
    }

    public List<ClientEditListRow> generate() {
        boolean found = false;
        getElements();
        for (WebElement element : elements) {
            if (element.findElements(By.xpath(".//span[@class='btn-group']/button")).size() != 0) {
                if (!found) {
                    WaitForVisible waitForVisible = new WaitForVisible(element);
                    waitForVisible.waitForVisible(60L, 100L);
                    EditButton editButton = new EditButton(driver, getEditButtonId(element));
                    rows.add(new ClientEditListRow(editButton, getName(element)));
                    found = true;
                } else {
                    EditButton editButton = new EditButton(driver, getEditButtonId(element));
                    rows.add(new ClientEditListRow(editButton, getName(element)));
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

    private String getName(WebElement element) {
        return element.getText().substring(5);
    }

}
