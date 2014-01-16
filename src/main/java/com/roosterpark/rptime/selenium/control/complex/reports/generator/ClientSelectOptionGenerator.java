package com.roosterpark.rptime.selenium.control.complex.reports.generator;

import com.roosterpark.rptime.selenium.control.Option;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * User: John
 * Date: 1/16/14
 * Time: 3:00 PM
 */
public class ClientSelectOptionGenerator {

    private WebElement parentElement;

    public ClientSelectOptionGenerator(WebElement parentElement) {
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
