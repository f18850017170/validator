package com.hqsf.utils.sign.convert;

public interface Converter<T> {
    Class<T> getTargetClass();
    String convert(T t);
}
