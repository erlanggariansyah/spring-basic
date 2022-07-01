package com.angga.springapp;

import com.angga.springapp.data.Food;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Slf4j
public class ScopeConfiguration {
    @Bean
    @Scope(scopeName = "prototype")
    public Food food() {
        log.info("Membuat food baru");
        return new Food();
    }
}
