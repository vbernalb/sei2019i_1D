package com.DataAcces.Models;

public class User {
    private String email;
    private String password;
    private int score;

    public User(String email, String password, int score) {
        this.email = email;
        this.password = password;
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }
}
