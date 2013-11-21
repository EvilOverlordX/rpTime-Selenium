package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 11/21/13
 * Time: 8:44 AM
 */
public class UserTimeSheetPage extends BasicPageObject {

    public UserTimeSheetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("User Time Sheet page should not be opened directly.");
    }

}
