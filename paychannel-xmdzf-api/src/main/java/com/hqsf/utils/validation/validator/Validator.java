package com.hqsf.utils.validation.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public interface Validator <T extends Object,K extends Annotation>{
    List<String> validate(Field field, T t, K k);
    Class<K> getAnnotation();
}
