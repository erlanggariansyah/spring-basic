package com.angga.springapp;

import com.angga.springapp.data.Barbeque;
import com.angga.springapp.repository.CartRepository;
import com.angga.springapp.repository.ProductRepository;
import com.angga.springapp.repository.ServiceRepository;
import com.angga.springapp.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTests {
    private static ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
    }

    @AfterEach
    void setDown() {
        context.close();
    }

    @Test
    void testComponentScan() {
        ProductService productService = context.getBean("productService", ProductService.class);

        Assertions.assertNotNull(productService);
    }

    @Test
    void testConstructorBasedDependencyInjection() {
        ProductService productService = context.getBean(ProductService.class);
        ServiceRepository serviceRepository = context.getBean(ServiceRepository.class);
        ServiceRepository serviceRepository1 = productService.getServiceRepository();

        Assertions.assertNotNull(serviceRepository);
        Assertions.assertSame(serviceRepository, serviceRepository1);
    }

    @Test
    void testSetterBasedDependencyInjection() {
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        ProductService productService = context.getBean(ProductService.class);

        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

    @Test
    void testFieldBasedDependencyInjection() {
        CartRepository cartRepository = context.getBean(CartRepository.class);
        ProductService productService = context.getBean(ProductService.class);

        Assertions.assertSame(cartRepository, productService.getCartRepository());
    }

    @Test
    void testBarbeque() {
        Barbeque barbeque = context.getBean(Barbeque.class);
        ProductService productService = context.getBean(ProductService.class);
        Barbeque barbeque1 = context.getBean("barbequeSecond", Barbeque.class);

        Assertions.assertNotSame(barbeque, productService.getBarbeque());
        Assertions.assertSame(barbeque1, barbeque);
    }
}
