package com.angga.springapp.data;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultiFooBar {
    @Getter
    private List<Food> foods;

    public MultiFooBar(ObjectProvider<Food> foodObjectProvider) {
        foods = foodObjectProvider.stream().collect(Collectors.toList());
    }
}
