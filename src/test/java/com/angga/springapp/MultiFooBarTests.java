package com.angga.springapp;

import com.angga.springapp.data.FooBar;
import com.angga.springapp.data.MultiFooBar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MultiFooBarTests {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(MultiFooBarConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testMultiFooBar() {
        MultiFooBar multiFooBar = context.getBean(MultiFooBar.class);

        Assertions.assertNotNull(multiFooBar);
        Assertions.assertEquals(1, multiFooBar.getFoods().size());
    }
}
