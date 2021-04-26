package com.miiwo.itemsonsale.models;

public class User {
    private String username;
    private String password;

    public User(String n, String p) {
        this.username = n;
        this.password = p;
    }

    public String getUsername() { return this.username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }
}
