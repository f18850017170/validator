package com.hqsf.enumcode;

/**
 * 支付渠道
 */
public enum XmdzfPayChannelEnum {
    wx_barcode_pay("微信条码支付"),
    ali_barcode_pay("支付宝条码支"),
    wx_scan_pay("微信扫码支付"),
    ali_scan_pay("支付宝扫码支付");
    private String desc;
    XmdzfPayChannelEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
