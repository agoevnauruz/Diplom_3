package org.example.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class UserGeneration  {

    public String userEmail() {
        String userEmail = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(5) + ".ru";
        return userEmail;
    }

    public String userPassword() {
        String userPassword = RandomStringUtils.randomNumeric(6);
        return userPassword;
    }
    public String userWrongPassword() {
        String userPassword = RandomStringUtils.randomNumeric(5);
        return userPassword;
    }

    public String userName() {
        String userName = RandomStringUtils.randomAlphabetic(7);
        return userName;
    }
}