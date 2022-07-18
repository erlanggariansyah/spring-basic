package com.angga.springapp;

import com.angga.springapp.data.Car;
import com.angga.springapp.processor.IdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanPostProcessorTests {
    @org.springframework.context.annotation.Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class
    })
    public static class Configuration {}

    private static ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(Configuration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testIdAwareGenerator() {
        Car car = context.getBean(Car.class);
        System.out.println(car.getId());

        Assertions.assertNotNull(car);
    }
}
