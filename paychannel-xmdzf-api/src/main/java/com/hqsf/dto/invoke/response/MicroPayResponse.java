package com.hqsf.dto.invoke.response;

import com.hqsf.enumcode.OrderStatusEnum;

/**
 * 刷卡支付（商户扫用户）,返回信息
 */
public class MicroPayResponse extends AbsResponse{
    private static final long serialVersionUID = 1348130385341451431L;
    /**
     * 支付宝微信生成的订单号 (交易成功时返回)
     */
    private String tradeNo;
    /**
     * 接入方订单号
     */
    private String outTradeNo;
    /**
     * 交易金额，单位为分
     */
    private Integer totalFee;
    /**
     * 成功支付时间 unix时间戳
     */
    private Long payTime;
    /**
     * 支付成功返回，在支付成功页面的条码下显示
     */
    private String referno;
    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatus;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public String getReferno() {
        return referno;
    }

    public void setReferno(String referno) {
        this.referno = referno;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "MicroPayResponse{" +
                "tradeNo='" + tradeNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", totalFee=" + totalFee +
                ", payTime=" + payTime +
                ", referno='" + referno + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
