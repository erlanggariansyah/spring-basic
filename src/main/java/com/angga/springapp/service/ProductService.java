package com.angga.springapp.service;

import com.angga.springapp.data.Barbeque;
import com.angga.springapp.repository.CartRepository;
import com.angga.springapp.repository.ProductRepository;
import com.angga.springapp.repository.ServiceRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@DependsOn(value = {
        "serviceRepository",
        "cartRepository",
        "productRepository"
})
@ComponentScan(basePackages = {
        "com.angga.springapp.multiconfig"
})
public class ProductService {
    @Getter
    private final ServiceRepository serviceRepository;

    @Getter
    private ProductRepository productRepository;

    @Getter
    @Autowired
    private CartRepository cartRepository;

    @Getter
    @Autowired
    @Qualifier(value = "barbequeFirst")
    private Barbeque barbeque;

    @Autowired
    public ProductService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ProductService(ServiceRepository serviceRepository, String nama) {
        this.serviceRepository = serviceRepository;
        log.info(nama);
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
