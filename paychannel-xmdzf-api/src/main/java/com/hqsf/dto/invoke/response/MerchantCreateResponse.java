package com.hqsf.dto.invoke.response;

import com.hqsf.enumcode.MerchantStatus;

public class MerchantCreateResponse extends AbsResponse{
    private static final long serialVersionUID = 9136576827368915603L;
    private MerchantStatus merchantStatus;//商户入件状态：
    private Integer merchantId;//商户编号

    public MerchantCreateResponse(MerchantStatus merchantStatus, Integer merchantId) {
        this.merchantStatus = merchantStatus;
        this.merchantId = merchantId;
    }

    public MerchantStatus getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(MerchantStatus merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}
