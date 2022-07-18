package com.angga.springapp;

import com.angga.springapp.data.PaymentGatewayFactoryBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = PaymentGatewayFactoryBean.class)
public class FactoryBeanConfiguration {
}
