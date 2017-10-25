package com.hqsf.utils.sign;

public interface SignContext<T extends SignInfoBuild> {
    /**
     * 对传入对象进行加签处理
     * @param t
     * @return
     * @throws IllegalArgumentException
     */
    String sign(T t) throws IllegalArgumentException;

    /**
     * 对传入对象进行加签处理（指定超类，即校验深度只到指定的超类）
     * @param t
     * @param superClass
     * @return 返回校验结果信息，校验通过时集合大小为0
     * @throws IllegalArgumentException
     */
    String sign(T t,Class<?> superClass) throws IllegalArgumentException;
}
