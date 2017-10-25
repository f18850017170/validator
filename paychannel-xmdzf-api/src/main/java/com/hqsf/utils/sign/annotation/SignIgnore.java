package com.hqsf.utils.sign.annotation;

import java.lang.annotation.*;

/**
 * 指定加密时忽略的字段
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SignIgnore {
}
