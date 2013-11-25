package com.roosterpark.rptime.selenium.control.complex.list.client;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.ClientPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/25/13
 * Time: 9:21 AM
 */
public class ClientLink extends Link<ClientPage> {

    private String id;

    public ClientLink(WebDriver driver, String id) {
        super(driver, id);
        this.id = id;
    }

    @Override
    public ClientPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new ClientPage(getDriver());
    }

    public String getId() {
        return id;
    }

}
