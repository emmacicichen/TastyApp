package com.myprojects.tastyapp.service;

import com.myprojects.tastyapp.dao.MenuInfoDao;
import com.myprojects.tastyapp.entity.MenuItem;
import com.myprojects.tastyapp.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {
    @Autowired
    private MenuInfoDao menuInfoDao;

    public List<Restaurant> getRestaurants() {
        return menuInfoDao.getRestaurants();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int id) {
        return menuInfoDao.getMenuItem(id);
    }
}
