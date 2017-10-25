package com.hqsf.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.hqsf.utils.sign.annotation.SignIgnore;

public class CustomExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        SignIgnore annotation = f.getAnnotation(SignIgnore.class);
        return annotation != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
