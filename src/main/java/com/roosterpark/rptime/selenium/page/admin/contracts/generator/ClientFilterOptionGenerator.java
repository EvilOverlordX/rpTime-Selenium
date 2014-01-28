package com.roosterpark.rptime.selenium.page.admin.contracts.generator;

import com.roosterpark.rptime.selenium.control.Option;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 1/28/14
 * Time: 9:43 AM
 */
public class ClientFilterOptionGenerator {

    private WebElement parentElement;

    public ClientFilterOptionGenerator(WebElement parentElement) {
        this.parentElement = parentElement;
    }

    public List<Option> generate() {
        List<Option> options = new LinkedList<>();
        List<WebElement> optionElements = getOptionElements();
        for (WebElement optionElement: optionElements) {
            String value = getValueFromElement(optionElement);
            String text = getTextFromElement(optionElement);
            options.add(new Option(text, value));
        }
        return options;
    }

    private List<WebElement> getOptionElements() {
        return parentElement.findElements(By.xpath(".//option"));
    }

    private String getValueFromElement(WebElement element) {
        return element.getAttribute("value");
    }

    private String getTextFromElement(WebElement element) {
        return element.getText().trim();
    }

}
