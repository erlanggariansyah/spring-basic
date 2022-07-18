package com.angga.springapp;

import com.angga.springapp.client.PaymentGateway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTests {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testFactoryBean() {
        PaymentGateway paymentGateway = context.getBean("paymentGateway", PaymentGateway.class);

        Assertions.assertNotNull(paymentGateway);
        Assertions.assertEquals("public", paymentGateway.getPublicKey());
        Assertions.assertEquals("private", paymentGateway.getPrivateKey());
    }
}
