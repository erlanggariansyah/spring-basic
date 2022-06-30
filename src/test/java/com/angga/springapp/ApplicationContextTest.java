package com.angga.springapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {
    @Test
    void contextTests() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);

        Assertions.assertNotNull(context);
    }
}
