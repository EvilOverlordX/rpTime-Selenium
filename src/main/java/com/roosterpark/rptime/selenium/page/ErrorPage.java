package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.exception.NotDirectlyOpenableException;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * User: John
 * Date: 12/17/13
 * Time: 9:55 AM
 */
public class ErrorPage extends BasicPageObject {

    private static final String STATUS_ID = "status";
    private static final String RESOLUTION_ID = "resolution";

    private String errorCode;
    private String errorMessage;
    private String resolutionText;

    public ErrorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        throw new NotDirectlyOpenableException("Error page should not be opened directly");
    }

    private void getStatus() {
        WebElement element = getWebDriver().findElement(By.id(STATUS_ID));
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();
        String pageText = element.getText().trim();
        String[] parts = pageText.split(" ");
        errorCode = parts[0];
        errorMessage = parts[1];
    }

    public String getErrorCode() {
        if (errorCode == null) {
            getStatus();
        }
        return errorCode;
    }

    public String getErrorMessage() {
        if (errorMessage == null) {
            getStatus();
        }
        return errorMessage;
    }

    private void getResolution() {
        WebElement element = getWebDriver().findElement(By.id(RESOLUTION_ID));
        WaitForVisible waitForVisible = new WaitForVisible(element);
        waitForVisible.defaultWaitForVisible();
        resolutionText = element.getText().trim();
    }

    public String getResolutionText() {
        if (resolutionText == null) {
            getResolution();
        }
        return resolutionText;
    }

}
