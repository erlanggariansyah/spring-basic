package com.angga.springapp.multiconfig;

import com.angga.springapp.data.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfiguration {
    @Bean
    public Food food() {
        return new Food();
    }
}
