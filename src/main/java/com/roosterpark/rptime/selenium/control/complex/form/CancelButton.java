package com.roosterpark.rptime.selenium.control.complex.form;

import com.roosterpark.rptime.selenium.control.Button;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/13/13
 * Time: 11:19 AM
 */
public class CancelButton extends Button<Void> {

    private static final String CANCEL_ID = "cancel";

    public CancelButton(WebDriver driver) {
        super(driver, CANCEL_ID);
    }

    @Override
    public Void click() {
        getElement().click();
        return null;
    }

}
