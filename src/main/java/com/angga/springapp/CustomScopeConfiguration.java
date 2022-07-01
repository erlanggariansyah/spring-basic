package com.angga.springapp;

import com.angga.springapp.data.Bar;
import com.angga.springapp.data.Food;
import com.angga.springapp.data.lifecycle.LifeCycle;
import com.angga.springapp.scope.DoubletonScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomScopeConfiguration {
    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("doubleton", new DoubletonScope());

        return customScopeConfigurer;
    }

    @Bean
    @Scope(scopeName = "doubleton")
    public Food food() {
        return new Food();
    }

    @Bean
    public LifeCycle lifeCycle() {
        return new LifeCycle();
    }

//    @Bean(initMethod = "startBar", destroyMethod = "endBar")
    @Bean
    public Bar bar() {
        return new Bar();
    }
}
