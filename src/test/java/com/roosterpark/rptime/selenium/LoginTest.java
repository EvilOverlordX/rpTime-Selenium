package com.roosterpark.rptime.selenium;

import com.roosterpark.rptime.selenium.page.LandingPage;
import com.roosterpark.rptime.selenium.page.RpTimePage;
import org.junit.Before;
import org.junit.Test;

/**
 * User: John
 * Date: 10/22/13
 * Time: 3:14 PM
 */
public class LoginTest extends BasicSeleniumTest {

    private LandingPage landingPage;
    private RpTimePage rpTimePage;

    @Before
    public void setup() {
        landingPage = new LandingPage(getDriver());
    }

    @Test
    public void loginTest() throws InterruptedException {
        landingPage.openPage();
        rpTimePage = landingPage.clickRpTimeLink();
        Thread.sleep(30000);
        rpTimePage.close();
    }

}
