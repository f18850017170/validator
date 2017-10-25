package com.hqsf.utils.sign;

public class SignContextFactory {
    public static SignContext buildSimpleSignContext(){
        return new SimpleSignContext();
    }
}
