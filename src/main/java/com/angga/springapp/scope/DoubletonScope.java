package com.angga.springapp.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.ArrayList;
import java.util.List;

public class DoubletonScope implements Scope {
    private List<Object> objects = new ArrayList<>(2);
    private Long counter = 0L;

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        counter++;

        if (counter == 2) {
            int index = (int) (counter % 2);
            return objects.get(index);
        } else {
            Object object = objectFactory.getObject();
            objects.add(object);
            return object;
        }
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
