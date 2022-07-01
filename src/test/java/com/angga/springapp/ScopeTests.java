package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTests {
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
    }

    @Test
    void testScope() {
        Food food = context.getBean("food", Food.class);
        Food food1 = context.getBean(Food.class);

        Assertions.assertNotSame(food, food1);
    }
}
