package com.myprojects.tastyapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 2652327633296064143L;
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enable;

    //define foreign key
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(unique=true)
    private Cart cart;

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

    public Cart getCart() {
        return cart;
    }

    public Customer setCart(Cart cart) {
        this.cart = cart;
        return this;
    }
}
