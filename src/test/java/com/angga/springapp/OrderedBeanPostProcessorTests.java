package com.angga.springapp;

import com.angga.springapp.data.Car;
import com.angga.springapp.data.Moto;
import com.angga.springapp.processor.IdGeneratorBeanPostProcessor;
import com.angga.springapp.processor.RandomNameBeanPostProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

public class OrderedBeanPostProcessorTests {
    @Configuration
    @Import(value = {
            Car.class,
            Moto.class,
            IdGeneratorBeanPostProcessor.class,
            RandomNameBeanPostProcessor.class
    })
    public static class OrderedConfiguration {}

    private static AnnotationConfigApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(OrderedConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testOrdered() {
        Car car = context.getBean(Car.class);
        System.out.println(car.getId());

        Moto moto = context.getBean(Moto.class);
        System.out.println(moto.getName());

        Assertions.assertNotNull(car);
        Assertions.assertNotNull(moto);
    }
}
