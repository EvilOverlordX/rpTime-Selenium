package com.roosterpark.rptime.selenium.user;

/**
 * User: John
 * Date: 12/9/13
 * Time: 2:11 PM
 */
public class TestUser implements User {

    private String username;
    private String password;

    public TestUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
