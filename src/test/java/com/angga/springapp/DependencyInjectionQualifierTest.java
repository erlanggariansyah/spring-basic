package com.angga.springapp;

import com.angga.springapp.data.Bar;
import com.angga.springapp.data.Food;
import com.angga.springapp.data.Warung;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionQualifierTest {
    private ApplicationContext context;

    @BeforeEach
    void settings() {
        context = new AnnotationConfigApplicationContext(DependencyInjectionQualifier.class);
    }

    @Test
    void testDependencyInjectionQualifier() {
        Food food = context.getBean(Food.class);
        Bar bar = context.getBean("bar", Bar.class);
        Warung warung = context.getBean(Warung.class);

        Assertions.assertNotNull(warung);
        Assertions.assertNotSame(food, warung.getFood());
        Assertions.assertNotSame(bar, warung.getBar());
    }
}
