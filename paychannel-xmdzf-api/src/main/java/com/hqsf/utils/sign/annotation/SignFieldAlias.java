package com.hqsf.utils.sign.annotation;

import java.lang.annotation.*;

/**
 * 字段别名
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SignFieldAlias {

    String value();
}
