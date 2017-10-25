package com.hqsf.utils.sign;

import com.hqsf.utils.MessageDigestUtils;

import java.util.*;

public class SimpleSignContext extends AbsSignContext<SignInfoBuild> {
    public SimpleSignContext() {
        super(null);
    }

    @Override
    public MessageDigestUtils.DigestType signType() {
        return MessageDigestUtils.DigestType.MD5;
    }

    @Override
    public String buildSignData(Map<String, String> fields,SignInfoBuild build) {
        StringBuilder builder = new StringBuilder();
        List<String> keys = new ArrayList<>(fields.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String key : keys) {
            String temp = fields.get(key);
            builder.append(key).append("=").append(temp).append("&");
        }
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }
}
