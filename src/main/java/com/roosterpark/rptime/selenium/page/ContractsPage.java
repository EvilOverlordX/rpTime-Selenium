package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.NavBarPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/25/13
 * Time: 2:11 PM
 */
public class ContractsPage extends NavBarPageObject{

    public ContractsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Contracts page should not be opened directly.");
    }
}
