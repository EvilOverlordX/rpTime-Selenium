package com.roosterpark.rptime.selenium.timer;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * User: John
 * Date: 11/4/13
 * Time: 1:29 PM
 */
public class WaitForVisible extends FluentWait<WebElement> {

    public WaitForVisible(WebElement input) {
        super(input);
    }

    public WaitForVisible(WebElement input, Clock clock, Sleeper sleeper) {
        super(input, clock, sleeper);
    }

    public void defaultWaitForVisible() {
        this.withTimeout(10, TimeUnit.SECONDS)
            .pollingEvery(100, TimeUnit.MILLISECONDS)
            .until(new Predicate<WebElement>() {
                @Override
                public boolean apply(WebElement element) {
                    return element.isDisplayed();
                }
            });
    }

    public void waitForVisible(long timeOutSeconds, long pollingMillis) {
        this.withTimeout(timeOutSeconds, TimeUnit.SECONDS)
                .pollingEvery(pollingMillis, TimeUnit.MILLISECONDS)
                .until(new Predicate<WebElement>() {
                    @Override
                    public boolean apply(WebElement element) {
                        return element.isDisplayed();
                    }
                });
    }

    public <K extends Throwable> WaitForVisible ignoreAll(Collection<Class<? extends K>> types) {
        super.ignoreAll(types);
        return this;
    }

    public WaitForVisible ignoring(Class<? extends Throwable> exceptionType) {
        super.ignoring(exceptionType);
        return this;
    }

    public WaitForVisible ignoring(Class<? extends Throwable> firstType, Class<? extends Throwable> secondType) {
        super.ignoring(firstType, secondType);
        return this;
    }

    public WaitForVisible pollingEvery(long duration, TimeUnit unit) {
        super.pollingEvery(duration, unit);
        return this;
    }

    public WaitForVisible withMessage(String message) {
        super.withMessage(message);
        return this;
    }

    public WaitForVisible withTimeout(long duration, TimeUnit unit) {
        super.withTimeout(duration, unit);
        return this;
    }

}
