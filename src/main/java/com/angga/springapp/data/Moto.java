package com.angga.springapp.data;

import com.angga.springapp.aware.RandomName;
import lombok.Getter;

public class Moto implements RandomName {
    @Getter
    String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
