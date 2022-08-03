package com.myprojects.tastyapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable  {

    private static final long serialVersionUID = 2652327633296064143L;

    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;
    //cascade.all All的意思是cascade里面所有的operations！
    @OneToOne(cascade = CascadeType.ALL)//Cascade集连操作，把与当前class的obj相关的其他class的obj也存起来。存Customer这个obj的时候，把Cart也存了。如果不写Cascade，你要自己手动保存cart
    @JoinColumn(unique = true)// this entity is the owner of the relationship (that is: the corresponding table has a column with a foreign key to the referenced table)
    private Cart cart;//foreign key


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
