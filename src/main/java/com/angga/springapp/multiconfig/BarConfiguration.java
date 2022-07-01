package com.angga.springapp.multiconfig;

import com.angga.springapp.data.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BarConfiguration {
    @Bean
    @Scope(scopeName = "prototype")
    public Bar bar() {
        return new Bar();
    }
}
