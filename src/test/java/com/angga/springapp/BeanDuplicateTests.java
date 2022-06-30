package com.angga.springapp;

import com.angga.springapp.data.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDuplicateTests {
    private ApplicationContext contextDuplicate;
    private ApplicationContext contextPrimary;

    @BeforeEach
    void setUp() {
        contextDuplicate = new AnnotationConfigApplicationContext(BeanConfigurationDuplicate.class);
        contextPrimary = new AnnotationConfigApplicationContext(BeanConfigurationPrimary.class);
    }

    @Test
    void testDuplicateBean() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Food food = contextDuplicate.getBean(Food.class);
        });
    }

    @Test
    void testDuplicateBeanWithName() {
        Food food = contextDuplicate.getBean("food", Food.class);
        Food food1 = contextDuplicate.getBean("food1", Food.class);

        Assertions.assertNotSame(food, food1);
    }

    @Test
    void testDuplicateBeanPrimary() {
        Food food = contextPrimary.getBean(Food.class);

        Assertions.assertNotNull(food);
    }

    @Test
    void testDuplicateBeanPrimaryDuplicate() {
        Food food = contextPrimary.getBean(Food.class);
        Food food1 = contextPrimary.getBean("food1", Food.class);

        Assertions.assertNotSame(food, food1);
    }

    @Test
    void testDuplicateBeanPrimaryDuplicatePrimary() {
        Food food = contextPrimary.getBean(Food.class);
        Food food1 = contextPrimary.getBean(Food.class);

        Assertions.assertSame(food, food1);
    }
}
