package com.myprojects.tastyapp.controller;

import com.myprojects.tastyapp.entity.MenuItem;
import com.myprojects.tastyapp.entity.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuInfoController {

    @RequestMapping(value="/restaurant/{restaurantId}/menu", method= RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenus(@PathVariable("restaurantId")int restaurantId){
      return new ArrayList<>();
    }

    @RequestMapping(value="/restaurants", method=RequestMethod.GET)
    @ResponseBody//convert java obj to JSON, and add to HTTP response body
    public List<Restaurant> getRestaurants(){
        return new ArrayList<>();
    }
}
