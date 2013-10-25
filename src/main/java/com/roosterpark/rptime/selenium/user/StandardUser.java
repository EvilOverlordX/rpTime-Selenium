package com.roosterpark.rptime.selenium.user;

/**
 * User: John
 * Date: 10/25/13
 * Time: 10:28 AM
 */
public class StandardUser implements User {

    private static final String USERNAME = "testuser@roosterpark.com";
    private static final String PASSWORD = "testuser";

    @Override
    public String getUsername() {
        return USERNAME;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }
}
