package com.angga.springapp;

import com.angga.springapp.data.FooBar;
import com.angga.springapp.data.Food;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OptionalTests {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testOptional() {
        Food food = context.getBean(Food.class);
        Food food1 = context.getBean("foodSecondary", Food.class);
        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNotSame(food, food1);
        Assertions.assertNotSame(food1, fooBar.getFood());
        Assertions.assertNull(fooBar.getBar());
    }
}
