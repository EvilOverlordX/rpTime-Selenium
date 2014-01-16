package com.roosterpark.rptime.selenium.control;

/**
 * User: John
 * Date: 1/16/14
 * Time: 1:52 PM
 */
public class Option {

    private String text;
    private String value;

    public Option(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        if (text != null ? !text.equals(option.text) : option.text != null) return false;
        if (value != null ? !value.equals(option.value) : option.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Option{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
