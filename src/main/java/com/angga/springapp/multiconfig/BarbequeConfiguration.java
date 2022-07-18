package com.angga.springapp.multiconfig;

import com.angga.springapp.data.Barbeque;
import com.angga.springapp.data.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BarbequeConfiguration {
    @Bean
    public Barbeque barbequeFirst() {
        return new Barbeque();
    }

    @Primary
    @Bean
    public Barbeque barbequeSecond() {
        return new Barbeque();
    }
}
