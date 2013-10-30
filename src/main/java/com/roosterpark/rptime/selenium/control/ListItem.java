package com.roosterpark.rptime.selenium.control;

/**
 * User: John
 * Date: 10/30/13
 * Time: 2:57 PM
 */
public class ListItem {

    private int value;
    private String text;

    public ListItem(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

}
