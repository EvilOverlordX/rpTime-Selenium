package com.roosterpark.rptime.selenium.control.complex.list.generator;

import com.roosterpark.rptime.selenium.control.complex.list.timesheet.UserTimeSheetRow;
import com.roosterpark.rptime.selenium.control.complex.list.timesheet.UserTimeSheetRowLink;
import com.roosterpark.rptime.selenium.control.complex.list.timesheet.status.Approved;
import com.roosterpark.rptime.selenium.control.complex.list.timesheet.status.Submitted;
import com.roosterpark.rptime.selenium.control.complex.list.timesheet.status.Unsubmitted;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 1/7/14
 * Time: 10:29 AM
 */
public class UserTimeSheetRowGenerator {

    private WebDriver driver;
    private List<UserTimeSheetRow> rows;

    public UserTimeSheetRowGenerator(WebDriver driver) {
        this.driver = driver;
        rows = new LinkedList<>();
    }

    public List<UserTimeSheetRow> generate() {
        List<WebElement> elements = getListItemElements(getListElement());
        for (WebElement element : elements) {
            Approved approved = new Approved(getApprovedElement(element));
            Submitted submitted = new Submitted(getSubmittedElement(element));
            Unsubmitted unsubmitted = new Unsubmitted(getUnsubmittedElement(element));
            WebElement linkElement = getLinkElement(element);
            UserTimeSheetRowLink link = new UserTimeSheetRowLink(driver, getLinkId(linkElement));
            rows.add(new UserTimeSheetRow(link, getWeek(linkElement), getDate(linkElement), getYear(linkElement),
                                          approved, submitted, unsubmitted));
        }
        return rows;
    }

    private WebElement getListElement() {
        return driver.findElement(By.id("userTimeSheetList"));
    }

    private List<WebElement> getListItemElements(WebElement element) {
        return element.findElements(By.xpath(".//li"));
    }

    private WebElement getApprovedElement(WebElement element) {
        return element.findElement(By.xpath(".//span[@id='timeSheetApproved']"));
    }

    private WebElement getSubmittedElement(WebElement element) {
        return element.findElement(By.xpath(".//span[@id='timeSheetSubmitted']"));
    }

    private WebElement getUnsubmittedElement(WebElement element) {
        return element.findElement(By.xpath(".//span[@id='timeSheetUnsubmitted']"));
    }

    private WebElement getLinkElement(WebElement element) {
        return element.findElement(By.xpath(".//a"));
    }

    private String getLinkId(WebElement element) {
        return element.getAttribute("id");
    }

    private Integer getYear(WebElement element) {
        String base = element.getText().trim();
        String[] parts = base.split(" ");
        return Integer.getInteger(parts[0].substring(0,3));
    }

    private Integer getWeek(WebElement element) {
        String base = element.getText().trim();
        String[] parts = base.split(" ");
        return Integer.getInteger(parts[2]);
    }

    private String getDate(WebElement element) {
        String base = element.getText().trim();
        String[] parts = base.split(" ");
        return parts[4];
    }

}
