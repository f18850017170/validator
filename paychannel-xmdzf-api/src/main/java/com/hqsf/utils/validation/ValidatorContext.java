package com.hqsf.utils.validation;

import java.util.List;

public interface ValidatorContext {
    /**
     * 校验传入对象的字段
     * @param t
     * @return 返回校验结果信息，校验通过时集合大小为0
     * @throws IllegalArgumentException
     */
    List<String> validate(Object t) throws IllegalArgumentException;

    /**
     * 校验传入对象的字段（指定超类，即校验深度只到指定的超类）
     * @param t
     * @param superClass
     * @return 返回校验结果信息，校验通过时集合大小为0
     * @throws IllegalArgumentException
     */
    List<String> validate(Object t,Class<?> superClass) throws IllegalArgumentException;
}
