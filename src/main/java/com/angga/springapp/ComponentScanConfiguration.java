package com.angga.springapp;

import com.angga.springapp.repository.CartRepository;
import com.angga.springapp.repository.ProductRepository;
import com.angga.springapp.repository.ServiceRepository;
import com.angga.springapp.service.ProductService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.angga.springapp.service"
}, basePackageClasses = {
        ServiceRepository.class,
        ProductRepository.class,
        CartRepository.class
})
public class ComponentScanConfiguration {
}
