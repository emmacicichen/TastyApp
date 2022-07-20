package com.myprojects.tastyapp.dao;

import com.myprojects.tastyapp.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    public void signUp(Customer customer) {

    }

    public Customer getCustomer(String email) {
        return new Customer();
    }

}
