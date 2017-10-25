package com.hqsf.utils.validation.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
    /**
     * 字段名称xxx（用于构建提示语句,eg: {xxx}不能为空）
     * @return
     */
    String value() default "";

    /**
     * 校验失败时的自定义提示信息
     * @return
     */
    String validatedFailMsg() default "";
    /**
     * 字符串类型时不为空
     * @return
     */
    boolean notBlank() default true;

    /**
     * 集合或者数组不能为空
     * @return
     */
    boolean notEmpty() default true;

    /**
     * 集合，数组，字符串最小值
     * @return
     */
    int minSize() default 0;
    /**
     * 集合，数组，字符串最大值
     * @return
     */
    int maxSize() default Integer.MAX_VALUE;

    /**
     * 最小值(数字类型有效)
     * @return
     */
    int min() default Integer.MIN_VALUE;

    /**
     * 最大值，数字类型有效
     * @return
     */
    int max() default Integer.MAX_VALUE;
}
