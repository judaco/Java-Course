package com.example.juda.myapplication;

/**
 * Created by Juda on 18/11/2016.
 */
public class Users {
    private String username, password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}