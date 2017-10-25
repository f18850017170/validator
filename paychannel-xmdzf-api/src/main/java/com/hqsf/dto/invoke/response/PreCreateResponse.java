package com.hqsf.dto.invoke.response;

/**
 * 扫码支付-微信/支付宝（用户扫商户）,返回信息
 */
public class PreCreateResponse extends AbsResponse{
    /**
     * 接入方订单号
     */
    private String outTradeNo;
    /**
     * tradeType为'NATIVE'时返回的动态二维码
     */
    private String qrCode;
    /**
     * 预支付交易会话标识，微信支付JSAPI类型时返回
     */
    private String prepayId;
    /**
     * 微信H5调起微信支付所需参数
     */
    private String appId;
    /**
     * 微信H5调起微信支付所需参数
     */
    private String timeStamp;
    /**
     * 微信H5调起微信支付所需参数
     */
    private String nonceStr;
    /**
     * 微信H5调起微信支付所需参数
     */
    private String signType;
    /**
     * 微信H5调起微信支付所需参数
     */
    private String paySign;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    @Override
    public String toString() {
        return "PreCreateResponse{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", appId='" + appId + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", signType='" + signType + '\'' +
                ", paySign='" + paySign + '\'' +
                '}';
    }
}
