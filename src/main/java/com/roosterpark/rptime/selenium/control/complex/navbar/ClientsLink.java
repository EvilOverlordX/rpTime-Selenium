package com.roosterpark.rptime.selenium.control.complex.navbar;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.ClientPage;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/24/13
 * Time: 1:20 PM
 */
public class ClientsLink extends Link<ClientPage> {

    private static final String CLIENTS_LINK = "Clients";

    public ClientsLink(WebDriver driver) {
        super(driver, CLIENTS_LINK);
    }

    @Override
    public ClientPage click() {
        getElement().click();
        return new ClientPage(getDriver());
    }
}
