package com.angga.springapp.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class FooBar {
    @Setter
    @Getter
    private Food food;

    @Setter
    @Getter
    private Bar bar;

    public FooBar(Food food, Bar bar) {
        this.food = food;
        this.bar = bar;
    }
}
