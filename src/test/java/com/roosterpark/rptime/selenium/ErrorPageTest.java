package com.roosterpark.rptime.selenium;

import com.roosterpark.rptime.selenium.mule.LoginMule;
import com.roosterpark.rptime.selenium.page.ErrorPage;
import com.roosterpark.rptime.selenium.user.TestUser;
import com.roosterpark.rptime.selenium.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: John
 * Date: 12/19/13
 * Time: 10:15 AM
 */
public class ErrorPageTest extends BasicSeleniumTest {

    private static final String EMAIL = "error.user.42@gmail.com";
    private static final String PASSWORD = "3rr05_P@55wd";

    private LoginMule loginMule;
    private User user;

    @Before
    public void setup() {
        loginMule = new LoginMule(getDriver());
        user = new TestUser(EMAIL, PASSWORD);
    }

    @Test
    public void errorPageTest() {
        ErrorPage errorPage = loginMule.errorLoginAsTestDefinedUser(user);
        errorPage.pauseForRedraw();
        assertEquals("Error code incorrect!", "403", errorPage.getErrorCode());
        assertEquals("Error message incorrect!", "FORBIDDEN", errorPage.getErrorMessage());
        assertTrue("Username not in resolution text!", errorPage.getResolutionText().contains(EMAIL));
        errorPage.close();
    }

}
