package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTests {
    @Test
    void beanTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);

        Food food = applicationContext.getBean(Food.class);
        Food food1 = applicationContext1.getBean(Food.class);

        Assertions.assertNotSame(food, food1);
    }
}
