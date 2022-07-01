package com.angga.springapp.data.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class LifeCycle implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info("Application context akan menghancurkan bean.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Application context selesai membuat bean.");
    }
}
