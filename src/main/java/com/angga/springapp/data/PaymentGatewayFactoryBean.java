package com.angga.springapp.data;

import com.angga.springapp.client.PaymentGateway;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component(value = "paymentGateway")
public class PaymentGatewayFactoryBean implements FactoryBean<PaymentGateway> {
    @Override
    public PaymentGateway getObject() throws Exception {
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setEndpoint("google.com");
        paymentGateway.setPrivateKey("private");
        paymentGateway.setPublicKey("public");

        return paymentGateway;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGateway.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
