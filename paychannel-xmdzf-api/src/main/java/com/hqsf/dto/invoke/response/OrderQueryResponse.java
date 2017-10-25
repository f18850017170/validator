package com.hqsf.dto.invoke.response;

import com.hqsf.enumcode.OrderStatusEnum;

public class OrderQueryResponse extends AbsResponse{
    private static final long serialVersionUID = 779985170081442326L;
    /**
     * 接入方订单号
     */
    private String outTradeNo;
    /**
     * 微信支付宝订单号
     */
    private String tradeNo;
    /**
     * 交易金额，单位为分
     */
    private Integer totalFee;
    /**
     * 成功支付时间 unix时间戳
     */
    private Long payTime;
    /**
     * 	在支付成功页面的条码下显示的号
     */
    private String referno;
    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatus;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
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
        return "OrderQueryResponse{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", totalFee=" + totalFee +
                ", payTime=" + payTime +
                ", referno='" + referno + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
