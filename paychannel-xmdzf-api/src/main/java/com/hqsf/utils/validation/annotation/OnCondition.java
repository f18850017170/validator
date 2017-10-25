package com.hqsf.utils.validation.annotation;

import com.hqsf.utils.validation.validator.ValidateCondition;

import java.lang.annotation.*;

/**
 * 条件注解，注解条件判断为true时，其他注解才会生效
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OnCondition {
    Class<? extends ValidateCondition>[] value();
}
