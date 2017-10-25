package com.hqsf.dto.invoke.request;

import com.hqsf.enumcode.XmdzfPayChannelEnum;
import com.hqsf.utils.validation.annotation.Required;

/**
 * 刷卡支付（商户扫用户）
 */
public class MicroPayRequest extends AbsRequest{
    @Required("支付渠道")
    private XmdzfPayChannelEnum channel;
    @Required(value = "订单号",maxSize = 64)//接入方订单号 不超过64位
    private String outTradeNo;
    @Required(value = "用户付款码",maxSize = 128)
    private String authCode;
    @Required("总金额")//总金额, 以分为单位
    private Integer totalFee;
    @Required(value = "商品标题",maxSize = 128)
    private String subject;
    @Required(value = "商品详情",maxSize = 128)
    private String body;
    private Integer expireMinutes;//创建支付订单后，订单关闭时间，单位为分钟。默认设置为5分钟,最长不超过30分钟，超过关单时间无法支付

    public XmdzfPayChannelEnum getChannel() {
        return channel;
    }

    public void setChannel(XmdzfPayChannelEnum channel) {
        this.channel = channel;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getExpireMinutes() {
        return expireMinutes;
    }

    public void setExpireMinutes(Integer expireMinutes) {
        this.expireMinutes = expireMinutes;
    }

    @Override
    public String toString() {
        return "MicroPayRequest{" +
                "channel=" + channel +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", authCode='" + authCode + '\'' +
                ", totalFee=" + totalFee +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", expireMinutes=" + expireMinutes +
                '}';
    }
}
