package com.hqsf.dto.invoke.response;

/**
 * 扫码支付（用户扫商户）-美团支付,返回信息
 */
public class MtdpPreCreateResponse extends AbsResponse{
    /**
     * 预支付订单token(调起美团钱包使用)
     */
    private String payToken;
    /**
     * 预支付订单号(调起美团钱包使用)
     */
    private String tradeNo;

    public String getPayToken() {
        return payToken;
    }

    public void setPayToken(String payToken) {
        this.payToken = payToken;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        return "MtdpPreCreateResponse{" +
                "payToken='" + payToken + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                '}';
    }
}
