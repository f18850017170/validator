package com.hqsf.dto.invoke.request;

import com.google.gson.annotations.Expose;
import com.hqsf.enumcode.XmdzfPayChannelEnum;
import com.hqsf.enumcode.XmdzfTradeType;
import com.hqsf.utils.validation.annotation.OnCondition;
import com.hqsf.utils.validation.annotation.Required;
import com.hqsf.utils.validation.validator.ValidateCondition;

/**
 * 扫码支付-微信/支付宝（用户扫商户）
 */
public class PreCreateRequest extends AbsRequest {
    private static final long serialVersionUID = 4547202914041216800L;
    /**
     * 接入方订单号，由接入方生成，不能重复
     */
    @Required(value = "订单号",maxSize = 64)
    private String outTradeNo;
    /**
     * 订单金额，单位为分
     */
    @Required("订单金额")
    private Integer totalFee;
    /**
     * 订单主题
     */
    @Required(value = "订单主题",maxSize = 64)
    private String subject;
    /**
     * 订单内容,不超过64个字符
     */
    @Required(value = "订单内容",maxSize = 64)
    private String body;
    /**
     * 支付渠道：
     * 'wx_barcode_pay':微信条码支付
     * 'ali_barcode_pay':支付宝条码支
     * 'wx_scan_pay':微信扫码支付
     * 'ali_scan_pay':支付宝扫码支付
     */
    @Required(value = "支付渠道")
    private XmdzfPayChannelEnum channel;
    /**
     * 暂未启用，创建支付订单后，订单关闭时间，目前固定2分钟
     */
    private Integer expireMinutes;
    /**
     * 交易类型
     * 'NATIVE'： 返回二维码url
     * 'JSAPI'： 返回会话标识等信息调起客户端支付sdk
     */
    @Required(value = "交易类型")
    private XmdzfTradeType tradeType;
    /**
     * 微信主扫且tradeType为JSAPI时必填,为支付宝或微信各自的openId，获取方式参考H5接口
     */
    @Required("微信/支付宝openId")
    @OnCondition(OpenIdOnValidateCondition.class)
    private String openId;
    /**
     * 支付成功通知回调地址
     */
    private String notifyUrl;

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

    public XmdzfPayChannelEnum getChannel() {
        return channel;
    }

    public void setChannel(XmdzfPayChannelEnum channel) {
        this.channel = channel;
    }

    public Integer getExpireMinutes() {
        return expireMinutes;
    }

    public void setExpireMinutes(Integer expireMinutes) {
        this.expireMinutes = expireMinutes;
    }

    public XmdzfTradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(XmdzfTradeType tradeType) {
        this.tradeType = tradeType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "PreCreateRequest{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", totalFee=" + totalFee +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", channel=" + channel +
                ", expireMinutes=" + expireMinutes +
                ", tradeType=" + tradeType +
                ", openId='" + openId + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
    public static class OpenIdOnValidateCondition implements ValidateCondition<PreCreateRequest> {

        @Override
        public boolean condition(PreCreateRequest obj) {
            return obj.getTradeType() == XmdzfTradeType.JSAPI;
        }
    }
}
