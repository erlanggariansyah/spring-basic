package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfigurationPrimary {
    @Primary
    @Bean
    public Food food() {
        return new Food();
    }

    @Bean
    public Food food1() {
        return new Food();
    }
}
