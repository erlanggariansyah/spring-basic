package com.angga.springapp;

import com.angga.springapp.data.Bar;
import com.angga.springapp.data.Food;
import com.angga.springapp.data.Warung;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DependencyInjectionQualifier {
    @Primary
    @Bean
    public Food food() {
        return new Food();
    }

    @Bean
    public Food food2() {
        return new Food();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public Bar bar2() {
        return new Bar();
    }

    @Bean
    public Warung warung(
            @Qualifier(value = "food2") Food food,
            @Qualifier(value = "bar2") Bar bar
    ) {
        return new Warung(food, bar);
    }
}
