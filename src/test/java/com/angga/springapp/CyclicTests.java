package com.angga.springapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyclicTests {
    @Test
    void testCyclic() {
        Assertions.assertThrows(UnsatisfiedDependencyException.class, () -> {
            ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
        });
    }
}
