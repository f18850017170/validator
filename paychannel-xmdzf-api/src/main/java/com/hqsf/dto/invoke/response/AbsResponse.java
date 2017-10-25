package com.hqsf.dto.invoke.response;

import com.hqsf.enumcode.StatusEnum;
import com.hqsf.utils.sign.SignInfoBuild;
import com.hqsf.utils.sign.annotation.SignIgnore;

import java.io.Serializable;

public abstract class AbsResponse implements SignInfoBuild, Serializable {
    protected StatusEnum status;//SUCCESS： 请求成功；FAIL：请求失败 请重试
    protected String errCode;//错误编码 （status 为失败的时候有）
    protected String errMsg;//错误消息描述（status 为失败的时候有）
    protected String subCode;//子错误码（status 为失败的时候有）
    protected String subMsg;//子错误码的描述（status 为失败的时候有）
    protected String random;//随机数（status为成功的时候有）
    protected String sign;//签名（status为成功的时候有）
    @SignIgnore
    protected String keyValueData;//数据为集合M,URL键值对的格式,参数名ASCII码从小到大排序（字典序）

    public boolean isSuccess() {
        return StatusEnum.SUCCESS == status;
    }



    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getKeyValueData() {
        return keyValueData;
    }

    @Override
    public void setKeyValueData(String keyValueData) {
        this.keyValueData = keyValueData;
    }

    @Override
    public String toString() {
        return "AbsResponse{" +
                "status=" + status +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", subCode='" + subCode + '\'' +
                ", subMsg='" + subMsg + '\'' +
                ", random='" + random + '\'' +
                ", sign='" + sign + '\'' +
                ", keyValueData='" + keyValueData + '\'' +
                '}';
    }
}
