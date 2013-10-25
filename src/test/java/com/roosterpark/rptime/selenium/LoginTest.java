package com.roosterpark.rptime.selenium;

import com.roosterpark.rptime.selenium.page.ConfirmationPage;
import com.roosterpark.rptime.selenium.page.HomePage;
import com.roosterpark.rptime.selenium.page.LandingPage;
import com.roosterpark.rptime.selenium.page.LoginPage;
import com.roosterpark.rptime.selenium.user.AdminUser;
import com.roosterpark.rptime.selenium.user.StandardUser;
import com.roosterpark.rptime.selenium.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    private User user;

    @Before
    public void setup() {
        landingPage = new LandingPage(getDriver());
    }

    @Test
    public void standardLoginTest() {
        user = new StandardUser();
        landingPage.openPage();
        loginPage = landingPage.clickSignInLink();
        confirmationPage = loginPage.signIn(user.getUsername(), user.getPassword());
        homePage = confirmationPage.confirm();
        assertFalse("Logged in as admin!", homePage.isLoggedInAsAdmin());
        homePage.close();
    }

    @Test
    public void adminLoginTest() {
        user = new AdminUser();
        landingPage.openPage();
        loginPage = landingPage.clickSignInLink();
        confirmationPage = loginPage.signIn(user.getUsername(), user.getPassword());
        homePage = confirmationPage.confirm();
        assertTrue("Not logged in as admin!", homePage.isLoggedInAsAdmin());
        homePage.close();
    }

}
