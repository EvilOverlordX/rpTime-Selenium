package com.roosterpark.rptime.selenium.mule;

import com.roosterpark.rptime.selenium.page.*;
import com.roosterpark.rptime.selenium.user.AdminUser;
import com.roosterpark.rptime.selenium.user.StandardUser;
import com.roosterpark.rptime.selenium.user.User;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: John
 * Date: 10/25/13
 * Time: 10:21 AM
 */
public class LoginMule {

    private WebDriver driver;
    private User user;

    private HomePage homePage;

    public LoginMule(WebDriver driver) {
        this.driver = driver;
    }

    public User getUser() {
        return user;
    }

    public HomePage loginAsAdmin() {
        user = new AdminUser();
        return loginAsTestDefinedAdminUser(user);
    }

    public UserTimeSheetPage loginAsStandard() {
        user = new StandardUser();
        return loginAsTestDefinedUser(user);
    }

    public UserTimeSheetPage loginAsTestDefinedUser(User user) {
        homePage = login(user);
        return new UserTimeSheetPage(driver);
    }

    public HomePage loginAsTestDefinedAdminUser(User user) {
        homePage = login(user);
        assertTrue("Not logged in as admin!", homePage.isAdminWarningVisible());
        return homePage;
    }

    private HomePage login(User user) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openPage();
        LoginPage loginPage = landingPage.clickSignInLink();
        ConfirmationPage confirmationPage = loginPage.signIn(user.getUsername(), user.getPassword());
        homePage = confirmationPage.confirm();
        return homePage;
    }

}
