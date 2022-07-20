package com.myprojects.tastyapp.service;

import com.myprojects.tastyapp.dao.CustomerDao;
import com.myprojects.tastyapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    public CustomerDao customerDao;

    public void signUp(Customer customer) {

    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }
}
