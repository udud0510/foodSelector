package com.yjlee.foodselector.application;

import com.yjlee.foodselector.domain.Restaurant;
import com.yjlee.foodselector.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository ;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository= restaurantRepository;
    }

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);
        return restaurant;
    }
}
