package com.hqsf.enumcode;

public enum MerchantStatus {
    WAIT("入件中"),
    ALREADY("已经入件"),
    REJECT("入件失败");
    private String desc;

    MerchantStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
