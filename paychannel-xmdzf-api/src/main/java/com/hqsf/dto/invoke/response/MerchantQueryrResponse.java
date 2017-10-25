package com.hqsf.dto.invoke.response;

/**
 * 商户入件信息查询返回信息
 */
public class MerchantQueryrResponse extends AbsResponse {
    private static final long serialVersionUID = 8805330043856650427L;

    private Integer merchantId;//商户编号，和请求参数对应

    private Integer wxRate;//微信费率，单位是万分之一，也就是30对应的是3‰

    private Integer aliRate;//支付宝费率，单位是万分之一，也就是30对应的是3‰

    private String merchantName;//商户名称

    private String address;//门店地址

    private String contactPerson;//门店联系人

    private String contractTel;//门店联系电话

    private String cardNo;//结算银行卡号

    private String accountName;//结算银行卡对应的开户人

    private String accountPersonIdCode;//结算银行卡开户人身份证或护照号

    private Integer bankAccountType;//账户类型，1:企业账户 2:个人账户

    private String bankName;//结算银行卡开户行名称

    private String bankBranchName;//结算银行卡开户支行名称

    private String bankBranchProvince;//结算银行卡开户支行所在省

    private String bankBranchCity;//结算银行卡开户支行所在市

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getWxRate() {
        return wxRate;
    }

    public void setWxRate(Integer wxRate) {
        this.wxRate = wxRate;
    }

    public Integer getAliRate() {
        return aliRate;
    }

    public void setAliRate(Integer aliRate) {
        this.aliRate = aliRate;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContractTel() {
        return contractTel;
    }

    public void setContractTel(String contractTel) {
        this.contractTel = contractTel;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPersonIdCode() {
        return accountPersonIdCode;
    }

    public void setAccountPersonIdCode(String accountPersonIdCode) {
        this.accountPersonIdCode = accountPersonIdCode;
    }

    public Integer getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(Integer bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankBranchProvince() {
        return bankBranchProvince;
    }

    public void setBankBranchProvince(String bankBranchProvince) {
        this.bankBranchProvince = bankBranchProvince;
    }

    public String getBankBranchCity() {
        return bankBranchCity;
    }

    public void setBankBranchCity(String bankBranchCity) {
        this.bankBranchCity = bankBranchCity;
    }

    @Override
    public String toString() {
        return "MerchantQueryrResponse{" +
                "merchantId=" + merchantId +
                ", wxRate=" + wxRate +
                ", aliRate=" + aliRate +
                ", merchantName='" + merchantName + '\'' +
                ", address='" + address + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contractTel='" + contractTel + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountPersonIdCode='" + accountPersonIdCode + '\'' +
                ", bankAccountType=" + bankAccountType +
                ", bankName='" + bankName + '\'' +
                ", bankBranchName='" + bankBranchName + '\'' +
                ", bankBranchProvince='" + bankBranchProvince + '\'' +
                ", bankBranchCity='" + bankBranchCity + '\'' +
                '}';
    }
}
