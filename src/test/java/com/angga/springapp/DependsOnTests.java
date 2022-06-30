package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnTests {
    @Test
    void testDependsOn() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
        context.getBean(Food.class);
        context.getBean(Food.class);
    }
}
