package com.angga.springapp;

import com.angga.springapp.data.Food;
import com.angga.springapp.data.MultiFooBar;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses = {
        MultiFooBar.class
})
public class MultiFooBarConfiguration {
    @Bean
    public Food food() {
        return new Food();
    }
}
