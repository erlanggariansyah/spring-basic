package com.angga.springapp.client;

import lombok.Data;

@Data
public class PaymentGateway {
    private String endpoint;
    private String privateKey;
    private String publicKey;
}
