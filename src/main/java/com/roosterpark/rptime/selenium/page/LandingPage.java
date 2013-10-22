package com.roosterpark.rptime.selenium.page;

import com.roosterpark.rptime.selenium.BasicPageObject;
import com.roosterpark.rptime.selenium.control.Link;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 10/22/13
 * Time: 1:24 PM
 */
public class LandingPage extends BasicPageObject {

    private static final String ADDRESS = "http://roosterparktime.appspot.com";

    private RpTimeLink rpTimeLink;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        getWebDriver().get(ADDRESS);
    }

    public RpTimePage clickRpTimeLink() {
        rpTimeLink = new RpTimeLink(getWebDriver());
        return rpTimeLink.click();
    }

    private class RpTimeLink extends Link<RpTimePage> {

        private static final String LINK_TEXT = "Rptime";

        public RpTimeLink(WebDriver driver) {
           super(driver, LINK_TEXT);
        }

        @Override
        public RpTimePage click() {
            getElement().click();
            return new RpTimePage(getDriver());
        }
    }

}
