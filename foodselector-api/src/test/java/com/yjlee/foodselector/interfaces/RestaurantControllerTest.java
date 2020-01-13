package com.yjlee.foodselector.interfaces;

import com.yjlee.foodselector.application.RestaurantService;
import com.yjlee.foodselector.domain.MenuItemRepository;
import com.yjlee.foodselector.domain.MenuItemRepositoryImpl;
import com.yjlee.foodselector.domain.RestaurantRepository;
import com.yjlee.foodselector.domain.RestaurantRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;
    // 테스트에 내가 사용할 Repository 선언
    @SpyBean(RestaurantService.class)
    private RestaurantService restaurantService;
    @SpyBean(RestaurantRepositoryImpl.class)
    private RestaurantRepository restaurantRepository;
    @SpyBean(MenuItemRepositoryImpl.class)
    private MenuItemRepository MenuItemRepository;

    @Test
    public void list() throws Exception {

        mvc.perform(get("/restaurants")).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
    }

    @Test
    public void detail() throws Exception {

        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("Kimchi")));

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2020")))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }
}