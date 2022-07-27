package com.myprojects.tastyapp.controller;

import com.myprojects.tastyapp.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {

    @RequestMapping(value="/cart", method= RequestMethod.GET)
    @ResponseBody
    public Cart getCart(){
        return new Cart();
    }
}
