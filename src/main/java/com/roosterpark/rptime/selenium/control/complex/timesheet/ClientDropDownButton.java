package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.control.complex.timesheet.generator.ClientDropDownPopupGenerator;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 11/27/13
 * Time: 9:58 AM
 */
public class ClientDropDownButton extends Button<ClientDropDownPopup> {

    private ClientDropDownPopup popup;

    public ClientDropDownButton(WebDriver driver, String id, WebElement menuElement) {
        super(driver, id);
        ClientDropDownPopupGenerator generator = new ClientDropDownPopupGenerator(driver, menuElement);
        popup = generator.generate();
    }

    @Override
    public ClientDropDownPopup click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return popup;
    }
}
