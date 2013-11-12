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

    private static final String ADDRESS = "http://roosterparktime-qa.appspot.com";

    private SignInLink signInLink;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        getWebDriver().get(ADDRESS);
    }

    public LoginPage clickSignInLink() {
        signInLink = new SignInLink(getWebDriver());
        return signInLink.click();
    }

    private class SignInLink extends Link<LoginPage> {

        private static final String LINK_TEXT = "Sign in";

        public SignInLink(WebDriver driver) {
            super(driver, LINK_TEXT);
        }

        @Override
        public LoginPage click() {
            getElement().click();
            return new LoginPage(getDriver());
        }
    }

}
