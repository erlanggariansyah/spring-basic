package com.angga.springapp;

import com.angga.springapp.data.Bar;
import com.angga.springapp.data.Food;
import com.angga.springapp.multiconfig.MainConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTests {
    ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(MainConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testImport() {
        Food food = context.getBean(Food.class);
        Bar bar = context.getBean(Bar.class);

        Assertions.assertNotNull(food);
        Assertions.assertNotNull(bar);
    }
}
