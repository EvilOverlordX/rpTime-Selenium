package com.roosterpark.rptime.selenium.control.finder;

import org.openqa.selenium.By;

/**
 * User: John
 * Date: 10/29/13
 * Time: 1:33 PM
 */
public abstract class FindByHelper {

    public abstract By find(String locator);

    public static class ByClass extends FindByHelper {

        @Override
        public By find(String locator) {
            return By.className(locator);
        }

    }

    public static class ByCssSelector extends FindByHelper {

        @Override
        public By find(String locator) {
            return By.cssSelector(locator);
        }

    }

    public static class ById extends FindByHelper {

        @Override
        public By find(String locator) {
            return By.id(locator);
        }

    }

    public static class ByLinkText extends FindByHelper {

        @Override
        public By find(String locator) {
            return By.linkText(locator);
        }

    }

    public static class ByName extends FindByHelper {

        @Override
        public By find(String locator) {
            return By.name(locator);
        }

    }

    public static class ByPartialLinkText extends FindByHelper {

        @Override
        public By find(String locator) {
            return By.partialLinkText(locator);
        }

    }

    public static class ByTagName extends FindByHelper {

        @Override
        public By find(String locator) {
            return By.tagName(locator);
        }

    }

    public static class ByXpath extends FindByHelper {

        @Override
        public By find(String locator) {
            return By.xpath(locator);
        }

    }

}


