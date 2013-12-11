package com.roosterpark.rptime.selenium.timer;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * User: John
 * Date: 12/11/13
 * Time: 11:31 AM
 */
public class WaitForPresent extends FluentWait<WebDriver>{

    public WaitForPresent(WebDriver input) {
        super(input);
    }

    public WaitForPresent(WebDriver input, Clock clock, Sleeper sleeper) {
        super(input, clock, sleeper);
    }

    public void defaultWaitForPresent(final By locator) {
        this.withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .until(new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                    }
                });
    }

    public void waitForPresent(long timeOutSeconds, long pollingMillis, final By locator) {
        this.withTimeout(timeOutSeconds, TimeUnit.SECONDS)
                .pollingEvery(pollingMillis, TimeUnit.MILLISECONDS)
                .until(new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                    }
                });
    }

    public <K extends Throwable> WaitForPresent ignoreAll(Collection<Class<? extends K>> types) {
        super.ignoreAll(types);
        return this;
    }

    public WaitForPresent ignoring(Class<? extends Throwable> exceptionType) {
        super.ignoring(exceptionType);
        return this;
    }

    public WaitForPresent ignoring(Class<? extends Throwable> firstType, Class<? extends Throwable> secondType) {
        super.ignoring(firstType, secondType);
        return this;
    }

    public WaitForPresent pollingEvery(long duration, TimeUnit unit) {
        super.pollingEvery(duration, unit);
        return this;
    }

    public WaitForPresent withMessage(String message) {
        super.withMessage(message);
        return this;
    }

    public WaitForPresent withTimeout(long duration, TimeUnit unit) {
        super.withTimeout(duration, unit);
        return this;
    }


}
