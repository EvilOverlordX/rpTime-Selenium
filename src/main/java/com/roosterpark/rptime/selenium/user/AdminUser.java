package com.roosterpark.rptime.selenium.user;

/**
 * User: John
 * Date: 10/25/13
 * Time: 10:24 AM
 */
public class AdminUser implements User {

    private static final String USERNAME = "testadmin@roosterpark.com";
    private static final String PASSWORD = "testadmin";

    @Override
    public String getUsername() {
        return USERNAME;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }
}
