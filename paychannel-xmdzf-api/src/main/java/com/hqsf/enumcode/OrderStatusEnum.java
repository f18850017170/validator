package com.hqsf.enumcode;

public enum  OrderStatusEnum {
    ORDER_NEW("交易新建"),
    ORDER_FAILED("交易失败"),
    ORDER_REVERSALING("交易冲正中"),
    ORDER_REVERSAL("交易冲正"),
    ORDER_SUCCESS("交易成功"),
    ORDER_PART_REFUND("交易半退"),
    ORDER_ALL_REFUND("交易全退"),
    ORDER_REFUNDING("退款中"),
    ORDER_CLOSE("交易失败");
    private String desc;

    OrderStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
