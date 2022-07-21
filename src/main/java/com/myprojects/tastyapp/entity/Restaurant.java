package com.myprojects.tastyapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="restaurants")
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 2455760938054036111L;

    @Id
    private int id;
    private String address;
    private String name;
    private String phone;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public Restaurant setId(int id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Restaurant setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Restaurant setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Restaurant setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
