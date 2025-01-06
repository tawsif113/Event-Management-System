package com.tawsif.eventmanagement.models;

import com.tawsif.eventmanagement.utility.Validator;

public class User {
    private static int idCounter = 0;
    private final int id;
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.id = ++idCounter;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public boolean validate() {
        return Validator.validateInput("email", email) && Validator.validateInput("phone", phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
