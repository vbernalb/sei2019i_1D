package com.DataAcces.Models;

public class Admin {
    private String email_admi;
    private String password_admi;

    public Admin(String email_admi, String password_admi) {
        this.email_admi = email_admi;
        this.password_admi = password_admi;
    }

    /**
     *
     * @return Email del admin
     */
    public String getEmail_admi() {
        return email_admi;
    }

    /**
     *
     * @return password del admin
     */
    public String getPassword_admi() {
        return password_admi;
    }
}
