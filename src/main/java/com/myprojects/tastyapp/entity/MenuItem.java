package com.myprojects.tastyapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="menuitem")
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    private int id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;

    //define foreign key
    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    public int getId() {
        return id;
    }

    public MenuItem setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MenuItem setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public MenuItem setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public MenuItem setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public MenuItem setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
