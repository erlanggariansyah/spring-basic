package com.angga.springapp;

import com.angga.springapp.data.Bar;
import com.angga.springapp.data.Food;
import com.angga.springapp.data.Warung;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DependencyInjectionConfiguration {
    @Primary
    @Bean
    public Food food() {
        return new Food();
    }

    @Bean
    public Food food1() {
        return new Food();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public Warung warung(Food food, Bar bar) {
        return new Warung(food, bar);
    }
}
