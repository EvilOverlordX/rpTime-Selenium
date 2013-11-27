package com.roosterpark.rptime.selenium.control.complex.timesheet;

import com.roosterpark.rptime.selenium.control.Button;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/27/13
 * Time: 9:58 AM
 */
public class ClientDropDownButton extends Button<ClientDropDownPopup> {

    private ClientDropDownPopup popup;

    public ClientDropDownButton(WebDriver driver, String id, ClientDropDownPopup popup) {
        super(driver, id);
        this.popup = popup;
        popup.setParentElement(getElement());
    }

    @Override
    public ClientDropDownPopup click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return popup;
    }
}
