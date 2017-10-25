package com.hqsf.dto.invoke.request;

import com.hqsf.utils.validation.annotation.Required;

/**
 * 扫码支付（用户扫商户）-美团支付
 */
public class MtdpPreCreateRequest extends AbsRequest{
    private static final long serialVersionUID = -3735120490498242273L;
    /**
     * mtdp_scan_pay 代表美团点评扫码
     */
    @Required("扫码类型")
    private String channel = "mtdp_scan_pay";
    /**
     * 美团点评用户id
     */
    @Required("用户id")
    private String userid;
    /**
     * 用来区分美团点评 1是美团 2是点评
     */
    @Required("支付类型")
    private String from;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "MtdpPreCreateRequest{" +
                "channel='" + channel + '\'' +
                ", userid='" + userid + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
