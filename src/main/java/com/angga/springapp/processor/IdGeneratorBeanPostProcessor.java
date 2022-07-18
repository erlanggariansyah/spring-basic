package com.angga.springapp.processor;

import com.angga.springapp.aware.IdAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class IdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public int getOrder() {
        return 99;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Id generator before initialization");
        if (bean instanceof IdAware idAware) {
            log.info("Set id for bean: " + beanName);
            idAware.setId(UUID.randomUUID().toString());
        }

        return bean;
    }
}
