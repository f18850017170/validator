package com.hqsf.utils;

import sun.misc.BASE64Encoder;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestUtils {
    /**
     * 根据加签类型以及字符类型，对指定字符串加签
     * @param temp
     * @param type
     * @param charSet
     * @return
     */
    public static String digest(String temp, DigestType type,Charset charSet){
        try {
            MessageDigest digest = MessageDigest.getInstance(type.name());
            byte[] bytes = digest.digest(temp.getBytes(charSet));
            BASE64Encoder base64Encoder= new BASE64Encoder();
            return base64Encoder.encode(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public enum DigestType {
        MD5,
        SHA256
    }
}
