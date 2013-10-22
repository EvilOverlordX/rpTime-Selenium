package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/22/13
 * Time: 2:55 PM
 */
public class WorkerPage extends BasicPageObject {

    public WorkerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Worker page should not be opened directly.");
    }

}
