package com.myprojects.tastyapp.service;

import com.myprojects.tastyapp.dao.ItemOrderDao;
import com.myprojects.tastyapp.entity.Customer;
import com.myprojects.tastyapp.entity.MenuItem;
import com.myprojects.tastyapp.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderService {
    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemOrderDao itemOrderDao;

    public void saveItem(int menuId) {
        final OrderItem orderItem = new OrderItem();
        final MenuItem menuItem = menuInfoService.getMenuItem(menuId);
        //1. get the current logged in user's obj
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();//return the current authenticated principal
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        //2. prepare the orderItem
        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        itemOrderDao.save(orderItem);
    }

}
