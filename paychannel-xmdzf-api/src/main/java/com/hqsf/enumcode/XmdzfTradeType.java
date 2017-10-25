package com.hqsf.enumcode;

/**
 * 交易类型
 */
public enum XmdzfTradeType {
    NATIVE("返回二维码url"),
    JSAPI("返回会话标识等信息调起客户端支付sdk");
    private String desc;
    XmdzfTradeType(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
