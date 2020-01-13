package com.yjlee.foodselector.application;

import com.yjlee.foodselector.domain.Restaurant;
import com.yjlee.foodselector.domain.RestaurantRepository;
import com.yjlee.foodselector.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class RestaurantServiceTest {
    RestaurantRepository restaurantRepository;
    private RestaurantService restaurantService;

    @Before
    public void setUp(){
        restaurantRepository = new RestaurantRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository);
    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId(),is(1004L));
    }

}