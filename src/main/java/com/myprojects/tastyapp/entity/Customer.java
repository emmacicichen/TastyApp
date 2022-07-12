package com.myprojects.tastyapp.entity;

public class Customer {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enable;

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isEnable() {
        return enable;
    }

    public Customer setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }
}
