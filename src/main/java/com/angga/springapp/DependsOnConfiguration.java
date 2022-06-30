package com.angga.springapp;

import com.angga.springapp.data.Bar;
import com.angga.springapp.data.Food;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

@Slf4j
@Configuration
public class DependsOnConfiguration {
    @Lazy
    @Bean
    @DependsOn(value = "bar")
    @Scope(scopeName = "singleton")
    public Food food() {
        log.info("Create new food.");
        return new Food();
    }

    @Bean
    public Bar bar() {
        log.info("Create new bar.");
        return new Bar();
    }
}
