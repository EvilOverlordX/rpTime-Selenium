package com.roosterpark.rptime.selenium.control.complex;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.page.HistoryPage;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/24/13
 * Time: 10:31 AM
 */
public class HistoryLink extends Link<HistoryPage> {

    private static final String HISTORY_LINK = "History";

    public HistoryLink(WebDriver driver) {
        super(driver, HISTORY_LINK);
    }

    @Override
    public HistoryPage click() {
        getElement().click();
        return new HistoryPage(getDriver());
    }
}
