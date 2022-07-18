package com.angga.springapp.processor;

import com.angga.springapp.aware.RandomName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import java.util.UUID;

@Slf4j
public class RandomNameBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RandomName randomName) {
            randomName.setName("Random Name: " + UUID.randomUUID());
            log.info("DONE RANDOMING NAME.");
        }

        return bean;
    }
}
