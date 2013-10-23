package com.roosterpark.rptime.selenium;

import com.roosterpark.rptime.selenium.page.ConfirmationPage;
import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.LandingPage;
import com.roosterpark.rptime.selenium.page.LoginPage;
import org.junit.Before;
import org.junit.Test;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:14 PM
 */
public class LoginTest extends BasicSeleniumTest {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private ConfirmationPage confirmationPage;
    private HomePage homePage;

    @Before
    public void setup() {
        landingPage = new LandingPage(getDriver());
    }

    @Test
    public void loginTest() throws InterruptedException {
        landingPage.openPage();
        loginPage = landingPage.clickSignInLink();
        confirmationPage = loginPage.signIn(getUsername(), getPassword());
        homePage = confirmationPage.confirm();
        Thread.sleep(30000);
        loginPage.close();
    }

}
