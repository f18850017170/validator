package com.hqsf.utils.validation;

/**
 * 工厂方法
 */
public class ValidatorContextFactory {

    public static ValidatorContext buildRequiredValidatorContext(){
        return new RequiredValidatorContext();
    }
}
