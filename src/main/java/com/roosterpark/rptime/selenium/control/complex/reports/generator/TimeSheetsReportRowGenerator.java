package com.roosterpark.rptime.selenium.control.complex.reports.generator;

import com.roosterpark.rptime.selenium.control.complex.reports.FlagButton;
import com.roosterpark.rptime.selenium.control.complex.reports.MyTimeSheetsLink;
import com.roosterpark.rptime.selenium.control.complex.reports.TimeSheetsReportRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 1/20/14
 * Time: 2:16 PM
 */
public class TimeSheetsReportRowGenerator {

    private WebDriver driver;
    private WebElement parentElement;

    public TimeSheetsReportRowGenerator(WebDriver driver, WebElement parentElement) {
        this.driver = driver;
        this.parentElement = parentElement;
    }

    public List<TimeSheetsReportRow> generate() {
        List<TimeSheetsReportRow> rows = new LinkedList<>();
        List<WebElement> tableRowElements = getTableRowElements();
        for (WebElement tableRowElement : tableRowElements) {
            MyTimeSheetsLink myTimeSheetsLink = new MyTimeSheetsLink(driver, getLinkId(tableRowElement));
            String hours = getHours(tableRowElement);
            FlagButton flagButton = new FlagButton(driver, getButtonId(tableRowElement));
            String date = getLinkText(tableRowElement);
            rows.add(new TimeSheetsReportRow(myTimeSheetsLink, hours, flagButton, date));
        }
        return rows;
    }

    private List<WebElement> getTableRowElements() {
        return parentElement.findElements(By.xpath(".//tr"));
    }

    private String getLinkId(WebElement element) {
        WebElement linkElement = element.findElement(By.xpath(".//td/a"));
        return linkElement.getAttribute("id");
    }

    private String getHours(WebElement element) {
        List<WebElement> tds = element.findElements(By.xpath(".//td"));
        String hours = "0.00";
        for (WebElement td : tds) {
            if (td.getAttribute("id").contains("hours-")) {
                hours = td.getText().trim();
            }
        }
        return hours;
    }

    private String getButtonId(WebElement element) {
        WebElement buttonElement = element.findElement(By.xpath(".//td/div/button"));
        return buttonElement.getAttribute("id");
    }

    private String getLinkText(WebElement element) {
        WebElement linkElement = element.findElement(By.xpath(".//td/a"));
        return linkElement.getText().trim();
    }

}
