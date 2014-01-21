package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.AdminPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 1/21/14
 * Time: 2:04 PM
 */
public class MyTimeSheetsPage extends AdminPageObject {

    public MyTimeSheetsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Time sheet page should not be opened directly.");
    }
}
