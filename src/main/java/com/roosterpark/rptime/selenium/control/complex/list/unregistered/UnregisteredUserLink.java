package com.roosterpark.rptime.selenium.control.complex.list.unregistered;

import com.roosterpark.rptime.selenium.control.Link;
import com.roosterpark.rptime.selenium.control.complex.form.CreateWorkerForm;
import com.roosterpark.rptime.selenium.control.finder.FindByHelper.ById;
import com.roosterpark.rptime.selenium.timer.WaitForVisible;
import org.openqa.selenium.WebDriver;

/**
 * User: John
 * Date: 12/20/13
 * Time: 10:06 AM
 */
public class UnregisteredUserLink extends Link<CreateWorkerForm> {

    public UnregisteredUserLink(WebDriver driver, String id) {
        super(driver, id, new ById());
    }

    @Override
    public CreateWorkerForm click() {
        WaitForVisible waitForVisible = new WaitForVisible(getElement());
        waitForVisible.defaultWaitForVisible();
        getElement().click();
        return new CreateWorkerForm(getDriver());
    }

    public boolean isEmailInLink(String email) {
        String linkText = getElement().getText().trim();
        return linkText.contains(email);
    }

}
