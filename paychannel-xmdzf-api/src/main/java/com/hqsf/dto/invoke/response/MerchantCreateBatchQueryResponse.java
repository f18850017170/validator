package com.hqsf.dto.invoke.response;

import com.hqsf.enumcode.MerchantStatus;

public class MerchantCreateBatchQueryResponse extends AbsResponse{
    private static final long serialVersionUID = 9043590812506777420L;
    private MerchantStatus merchantStatus;//商户入件状态：
    private String merchantId;//如果一个商户的入件状态查不到，则这个商户返回空

    public MerchantStatus getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(MerchantStatus merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }


    @Override
    public String toString() {
        return "MerchantCreateBatchQueryResponse{" +
                "merchantStatus=" + merchantStatus +
                ", merchantId='" + merchantId + '\'' +
                '}';
    }
}
