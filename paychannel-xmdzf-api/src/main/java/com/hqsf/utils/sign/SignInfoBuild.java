package com.hqsf.utils.sign;

public interface SignInfoBuild {
    /**
     * 回调键值对的值
     * @param keyValueData
     */
    void setKeyValueData(String keyValueData);

    /**
     * 回填加签的结果值
     * @param sign
     */
    void setSign(String sign);
}
