package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.stream.Collectors;

public class BeanFactoryTests {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testBeanFactory() {
        ObjectProvider<Food> foodObjectProvider = context.getBeanProvider(Food.class);
        System.out.println(foodObjectProvider.stream().collect(Collectors.toList()));

        Map<String, Food> stringFoodMap = context.getBeansOfType(Food.class);
        System.out.println(stringFoodMap);

        Food food = context.getBean(Food.class);
    }
}
