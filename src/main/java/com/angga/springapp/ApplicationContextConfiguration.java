package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfiguration {
    @Bean
    public Food food() {
        return new Food();
    }
}
