package com.yjlee.foodselector.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepository {
    @Override
    public List<MenuItem> findAllByRestaurantId(Long restaurantId) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));
        return menuItems;
    }
}
