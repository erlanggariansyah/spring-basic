package com.angga.springapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTests {
    @Test
    void productTest() {
        Product product1 = Product.getInstance();
        Product product2 = Product.getInstance();

        Assertions.assertSame(product1, product2);
    }
}
