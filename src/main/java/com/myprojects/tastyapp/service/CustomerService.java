package com.myprojects.tastyapp.service;

import com.myprojects.tastyapp.dao.CustomerDao;
import com.myprojects.tastyapp.entity.Cart;
import com.myprojects.tastyapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    public CustomerDao customerDao;

    /**
    * 1. assign a cart to the new customer
     * 2. set enable
     * 3. save customer to db
    * */
    public void signUp(Customer customer) {
        System.out.println("this is service layer");
        Cart cart = new Cart();
        customer.setCart(cart);

        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }
}
