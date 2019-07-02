package com.DataAcces.Models;

public class User {
    private String email_user;
    private String password_user;
    private int acumulate_score;

    public User(String email_user, String password_user, int score) {
        this.email_user = email_user;
        this.password_user = password_user;
        this.acumulate_score = score;
    }

    public String getEmail_user() {
        return email_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public int getAcumulate_score() {
        return acumulate_score;
    }
}
