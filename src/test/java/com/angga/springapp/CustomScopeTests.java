package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomScopeTests {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(CustomScopeConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testDoubleton() {
        Food food = context.getBean(Food.class);
        Food food1 = context.getBean(Food.class);
        Food food2 = context.getBean(Food.class);
        Food food3 = context.getBean(Food.class);

        Assertions.assertNotSame(food1, food2);
        Assertions.assertSame(food, food2);
        Assertions.assertNotSame(food, food3);
    }
}
