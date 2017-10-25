package com.hqsf.dto.invoke.request;

import com.hqsf.utils.validation.annotation.Required;

/**
 * 订单查询
 */
public class OrderQueryRequest extends AbsRequest{
    private static final long serialVersionUID = 8662308634104619756L;
    @Required(value = "订单号",maxSize = 64)//接入方订单号
    private String outTradeNo;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    public String toString() {
        return "OrderQueryRequest{" +
                "outTradeNo='" + outTradeNo + '\'' +
                '}';
    }
}
