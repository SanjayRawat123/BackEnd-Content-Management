/*
 * Author Name:
 * Date: 12/14/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.sanjay.example.contentmenagement.model;

public class JwtRequset {
    String userName;
    String password;

    public JwtRequset() {
    }

    public JwtRequset(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public JwtRequset setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public JwtRequset setPassword(String password) {
        this.password = password;
        return this;
    }
}
