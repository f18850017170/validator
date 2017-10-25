package com.hqsf.dto.invoke.request;

import com.hqsf.utils.sign.SignInfoBuild;
import com.hqsf.utils.sign.annotation.SignIgnore;
import com.hqsf.utils.validation.annotation.Required;

import java.io.Serializable;

public abstract class AbsRequest implements SignInfoBuild, Serializable {
    @Required("签名")
    @SignIgnore
    protected String sign;//验证签名
    protected String merchantId;//开放平台分配的商户id, 目前是 美团POI ID
    protected String random;//随机数String(32)
    protected String appId;//接入方标识，由美团开放平台分配（发送邮件至xucancan@meituan.com）
    protected String wxSubAppId;//用到小程序支付才有，申请小程序时微信分配的小程序的appid
    @SignIgnore
    protected String keyValueData;//数据为集合M,URL键值对的格式,参数名ASCII码从小到大排序（字典序）

    public String getWxSubAppId() {
        return wxSubAppId;
    }

    public void setWxSubAppId(String wxSubAppId) {
        this.wxSubAppId = wxSubAppId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getKeyValueData() {
        return keyValueData;
    }

    public void setKeyValueData(String keyValueData) {
        this.keyValueData = keyValueData;
    }

    @Override
    public String toString() {
        return "AbsRequest{" +
                "sign='" + sign + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", random='" + random + '\'' +
                ", appId='" + appId + '\'' +
                ", wxSubAppId='" + wxSubAppId + '\'' +
                ", keyValueData='" + keyValueData + '\'' +
                '}';
    }
}
