package com.hqsf.dto.invoke.request;

import com.hqsf.utils.validation.annotation.OnCondition;
import com.hqsf.utils.validation.annotation.Required;
import com.hqsf.utils.validation.validator.ValidateCondition;

public class MerchantCreateRequest extends AbsRequest {
    //账户类型，1:企业账户 2:个人账户
    public static final int BUSSINESS_BANK_ACCOUNT_TYPE = 1;//1:企业账户
    public static final int CUSTOMER_BANK_ACCOUNT_TYPE = 2;//2:个人账户
    private static final long serialVersionUID = 2751557605137570117L;

    @Required(value = "门店简称", maxSize = 64)//门店简称，会显示在支付页面中
    private String merchantName;

    @Required(value = "门店地址", maxSize = 128)//门店地址
    private String address;

    @Required("账户类型")
    private Integer bankAccountType;

    @Required(value = "银行卡号", maxSize = 32)
    private String cardNo;

    @Required(value = "账户名称", maxSize = 32)
    private String accountName;

    @Required("开户行总行编号")
    private Integer bankId;

    @Required("开户行分行编号")
    private Integer bankBranchId;

    @Required("开户行所在省份编号")
    private Integer bankProvinceId;

    @Required("开户行所在城市编号")
    private Integer bankCityId;

    @Required(value = "账户人身份证号码", maxSize = 32)//账户人身份证号码 如果账户类型是对私，则必须提供身份证号码
    @OnCondition(CustomerAccountType.class)
    private String accountPersonIdCode;

    @Required(value = "账户人联系电话", maxSize = 32)
    private String contactPhone;

    @Required("微信费率")//微信费率，单位为：万分之一，比如费率为 0.6%, 需要传 60
    private Integer wxRate;

    @Required("支付宝费率")//支付宝费率，单位为：万分之一，比如费率为 0.6%, 需要传 60
    private Integer aliRate;

    private String businessLicenceName;//营业执照名称

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

    public Integer getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(Integer bankAccountType) {
        this.bankAccountType = bankAccountType;
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

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getBankBranchId() {
        return bankBranchId;
    }

    public void setBankBranchId(Integer bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    public Integer getBankProvinceId() {
        return bankProvinceId;
    }

    public void setBankProvinceId(Integer bankProvinceId) {
        this.bankProvinceId = bankProvinceId;
    }

    public Integer getBankCityId() {
        return bankCityId;
    }

    public void setBankCityId(Integer bankCityId) {
        this.bankCityId = bankCityId;
    }

    public String getAccountPersonIdCode() {
        return accountPersonIdCode;
    }

    public void setAccountPersonIdCode(String accountPersonIdCode) {
        this.accountPersonIdCode = accountPersonIdCode;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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

    public String getBusinessLicenceName() {
        return businessLicenceName;
    }

    public void setBusinessLicenceName(String businessLicenceName) {
        this.businessLicenceName = businessLicenceName;
    }

    @Override
    public String toString() {
        return "MerchantCreateRequest{" +
                "merchantName='" + merchantName + '\'' +
                ", address='" + address + '\'' +
                ", bankAccountType=" + bankAccountType +
                ", cardNo='" + cardNo + '\'' +
                ", accountName='" + accountName + '\'' +
                ", bankId=" + bankId +
                ", bankBranchId=" + bankBranchId +
                ", bankProvinceId=" + bankProvinceId +
                ", bankCityId=" + bankCityId +
                ", accountPersonIdCode='" + accountPersonIdCode + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", wxRate=" + wxRate +
                ", aliRate=" + aliRate +
                ", businessLicenceName='" + businessLicenceName + '\'' +
                '}';
    }

    /**
     * 个人账户
     */
    public static class CustomerAccountType implements ValidateCondition<MerchantCreateRequest> {

        @Override
        public boolean condition(MerchantCreateRequest obj) {
            return obj.getBankAccountType() == CUSTOMER_BANK_ACCOUNT_TYPE;
        }
    }
}
