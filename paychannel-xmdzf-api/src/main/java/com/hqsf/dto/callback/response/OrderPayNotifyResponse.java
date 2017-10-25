package com.hqsf.dto.callback.response;

import com.hqsf.enumcode.StatusEnum;

/**
 * 在订单支付成功后进行回调通知,返回
 */
public class OrderPayNotifyResponse extends AbsResponse{
    private static final long serialVersionUID = -4823318453942663998L;
    private StatusEnum status;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderPayNotifyResponse{" +
                "status=" + status +
                '}';
    }
}
