package com.myprojects.tastyapp.controller;

import com.myprojects.tastyapp.entity.Customer;
import com.myprojects.tastyapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {
    @Autowired
    private CustomerService customerService;
    //@RequestMapping define RESTFUL API
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)//enum,return 201 created
    public void signUp(@RequestBody Customer customer) {//RequestBody converts http request body to java obj

    }
}
