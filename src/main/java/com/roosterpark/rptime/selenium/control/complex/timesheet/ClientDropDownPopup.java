package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: John
 * Date: 11/27/13
 * Time: 9:59 AM
 */
public class ClientDropDownPopup {

    private Map<String, ClientDropDownLink> linkMap;
    private ClientDropDownLink paidTimeOff;
    private WebDriver driver;
    private WebElement parentElement;

    public ClientDropDownPopup(WebDriver driver, List<ClientDropDownLink> links) {
        this.driver = driver;
        paidTimeOff = new ClientDropDownLink(driver, "Paid time off");
        linkMap = new HashMap<>();
        linksByName(links);
    }

    private void linksByName(List<ClientDropDownLink> links) {
        for (ClientDropDownLink link : links) {
            linkMap.put(link.getName(), link);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setParentElement(WebElement element) {
        parentElement = element;
    }

    public void view() {
        WebElement element = parentElement.findElement(By.xpath(".//ul[@class='dropdown-menu']"));
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();

    }

    public void clickClientByName(String name) {
        linkMap.get(name).click();
    }

    public void clickPaidTimeOff() {
        paidTimeOff.click();
    }

}
