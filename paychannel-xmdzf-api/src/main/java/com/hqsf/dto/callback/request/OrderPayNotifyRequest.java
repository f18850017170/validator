package com.hqsf.dto.callback.request;

import com.hqsf.enumcode.TradeStatusEnum;

/**
 * 在订单支付成功后进行回调通知
 */
public class OrderPayNotifyRequest extends AbsRequest{
    private static final long serialVersionUID = 1702270101230564513L;
    /**
     * 接入分配的渠道号
     */
    private String appId;
    /**
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * 支付时间，时间戳单位毫秒
     */
    private Long payTime;
    /**
     *美团开放平台交易号
     */
    private String transactionId;
    /**
     * 第三方支付交易单号即微信支付宝交易号
     */
    private String providerTradeNo;
    /**
     * 用户openId
     */
    private String openId;
    /**
     * 参数签名
     */
    private String sign;
    /**
     * 订单金额，单位分
     */
    private Integer totalFee;
    /**
     * 随机数
     */
    private String nonce_str;
    /**
     * 交易状态，当前的有 TRADE_SUCCESS, 表示交易成功
     */
    private TradeStatusEnum tradeStatus;
    /**
     * 当接入方的微信相关支付使用的是自己的微信appId时，表示用户在该appId下的openId
     */
    private String subOpenId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getProviderTradeNo() {
        return providerTradeNo;
    }

    public void setProviderTradeNo(String providerTradeNo) {
        this.providerTradeNo = providerTradeNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public TradeStatusEnum getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatusEnum tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getSubOpenId() {
        return subOpenId;
    }

    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }

    @Override
    public String toString() {
        return "OrderPayNotifyRequest{" +
                "appId='" + appId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", payTime=" + payTime +
                ", transactionId='" + transactionId + '\'' +
                ", providerTradeNo='" + providerTradeNo + '\'' +
                ", openId='" + openId + '\'' +
                ", sign='" + sign + '\'' +
                ", totalFee=" + totalFee +
                ", nonce_str='" + nonce_str + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", subOpenId='" + subOpenId + '\'' +
                '}';
    }
}
