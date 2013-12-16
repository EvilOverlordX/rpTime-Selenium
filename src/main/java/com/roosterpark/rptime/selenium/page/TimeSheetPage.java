package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.AdminPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:07 PM
 */
public class TimeSheetPage extends AdminPageObject {

    public TimeSheetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Time sheet page should not be opened directly.");
    }

}
