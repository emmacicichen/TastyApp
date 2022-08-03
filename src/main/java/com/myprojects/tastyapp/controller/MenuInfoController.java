package com.myprojects.tastyapp.controller;

import com.myprojects.tastyapp.entity.MenuItem;
import com.myprojects.tastyapp.entity.Restaurant;
import com.myprojects.tastyapp.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuInfoController {
    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping(value="/restaurant/{restaurantId}/menu", method= RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenus(@PathVariable("restaurantId")int restaurantId){
      return menuInfoService.getAllMenuItem(restaurantId);
    }

    @RequestMapping(value="/restaurants", method=RequestMethod.GET)
    @ResponseBody//convert java obj to JSON, and add to HTTP response body
    public List<Restaurant> getRestaurants(){
        return menuInfoService.getRestaurants();
    }
}
