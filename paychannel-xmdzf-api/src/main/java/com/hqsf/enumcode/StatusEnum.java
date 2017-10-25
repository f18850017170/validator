package com.hqsf.enumcode;

public enum StatusEnum {
    SUCCESS("成功"),
    FAIL("失败"),
    UNKNOWN("未知状态");
    private String desc;

    StatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
