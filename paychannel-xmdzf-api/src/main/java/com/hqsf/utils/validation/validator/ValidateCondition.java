package com.hqsf.utils.validation.validator;

public interface ValidateCondition<T> {
    boolean condition(T obj);
}
