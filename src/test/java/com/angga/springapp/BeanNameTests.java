package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanNameTests {
    private ApplicationContext context;

    @BeforeEach
    void settings() {
        context = new AnnotationConfigApplicationContext(BeanConfigurationName.class);
    }

    @Test
    void testBeanName() {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> {
            Food food = context.getBean("food", Food.class);
        });
    }

    @Test
    void testBeanNameDuplicate() {
        Food food = context.getBean("FastFood", Food.class);
        Food food1 = context.getBean("SlowFood", Food.class);

        Assertions.assertNotSame(food, food1);
    }
}
