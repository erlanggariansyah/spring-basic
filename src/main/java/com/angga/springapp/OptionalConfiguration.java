package com.angga.springapp;

import com.angga.springapp.data.Bar;
import com.angga.springapp.data.FooBar;
import com.angga.springapp.data.Food;
import com.angga.springapp.data.Warung;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

@Configuration
public class OptionalConfiguration {
    @Bean
    public Food foodSecondary() {
        return new Food();
    }

    @Primary
    @Bean
    public Food foodPrimary() {
        return new Food();
    }

    @Bean
    public FooBar fooBar(
            Optional<Food> food,
            Optional<Bar> bar
    ) {
        return new FooBar(food.orElse(null), bar.orElse(null));
    }
}
