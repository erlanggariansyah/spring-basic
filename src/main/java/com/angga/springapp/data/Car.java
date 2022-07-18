package com.angga.springapp.data;

import com.angga.springapp.aware.IdAware;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Car implements IdAware {
    @Getter
    String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
