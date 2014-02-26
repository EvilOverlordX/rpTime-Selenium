package com.roosterpark.rptime.selenium.control.complex.navbar.link;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.admin.ContractsPage;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/25/13
 * Time: 2:14 PM
 */
public class ContractsLink extends Link<ContractsPage> {

    private static final String CONTRACTS_LINK = "Contracts";

    public ContractsLink(WebDriver driver) {
        super(driver, CONTRACTS_LINK);
    }

    @Override
    public ContractsPage click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new ContractsPage(getDriver());
    }
}
