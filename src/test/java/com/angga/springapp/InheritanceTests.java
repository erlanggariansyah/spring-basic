package com.angga.springapp;

import com.angga.springapp.data.UserServiceImpl;
import com.angga.springapp.data.interfaces.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InheritanceTests {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testInheritance() {
        UserService userService = context.getBean(UserService.class);
        UserServiceImpl userServiceImpl = context.getBean(UserServiceImpl.class);

        Assertions.assertSame(userService, userServiceImpl);
    }
}
