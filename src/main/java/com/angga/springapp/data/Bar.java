package com.angga.springapp.data;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class Bar {
    @PostConstruct
    public void startBar() {
        log.info("Starting bar server..");
    }

    @PreDestroy
    public void endBar() {
        log.info("End bar server..");
    }
}
