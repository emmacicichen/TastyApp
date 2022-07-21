package com.myprojects.tastyapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="orderitem")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -2455760938054036364L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    private double price;

    @ManyToOne
    private MenuItem menuItem;

    @ManyToOne
    @JsonIgnore//when return a Cart obj, don't include this cart field
    private Cart cart;

    public int getId() {
        return id;
    }

    public OrderItem setId(int id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public OrderItem setPrice(double price) {
        this.price = price;
        return this;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public OrderItem setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        return this;
    }

    public Cart getCart() {
        return cart;
    }

    public OrderItem setCart(Cart cart) {
        this.cart = cart;
        return this;
    }
}
