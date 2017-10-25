package com.hqsf.dto.invoke.request;

public class MerchantCreateBatchQueryRequest extends AbsRequest{
    private static final long serialVersionUID = -782214520037387006L;
    private String merchantIdList;//支持批量查询，商户编号集合 中间用逗号隔开 格式为：商户编号1,商户编号2,商户编号3 最大支持查询的商户数量不超过100个

    public String getMerchantIdList() {
        return merchantIdList;
    }

    public void setMerchantIdList(String merchantIdList) {
        this.merchantIdList = merchantIdList;
    }

    public MerchantCreateBatchQueryRequest(String merchantIdList) {
        this.merchantIdList = merchantIdList;
    }
}
