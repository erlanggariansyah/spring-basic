package com.angga.springapp;

public class Product {
    public static Product product;

    private Product(){}

    public static Product getInstance() {
        if (product == null) {
            product = new Product();
        }

        return product;
    }
}
