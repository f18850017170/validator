package com.hqsf.enumcode;

public enum  TradeStatusEnum {
    TRADE_SUCCESS("交易成功");
    private String desc;

    TradeStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
