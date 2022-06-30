package com.angga.springapp;

import com.angga.springapp.data.Bar;
import com.angga.springapp.data.Food;
import com.angga.springapp.data.Warung;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTests {
    private ApplicationContext context;

    @BeforeEach
    void settings() {
        context = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }

    @Test
    void withoutDependecyInjection() {
        Food food = context.getBean("food", Food.class);
        Bar bar = context.getBean("bar", Bar.class);

        Warung warung = new Warung(food, bar);

        Assertions.assertNotNull(warung);
        Assertions.assertSame(food, warung.getFood());
        Assertions.assertSame(bar, warung.getBar());
    }

    @Test
    void withDependencyInjection() {
        Warung warung = context.getBean(Warung.class);

        Assertions.assertNotNull(warung);
    }
}
