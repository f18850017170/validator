package com.hqsf.utils.validation;

import com.hqsf.utils.validation.validator.RequiredAnnotationValidator;

public class RequiredValidatorContext extends AbsValidatorContext {
    public RequiredValidatorContext(){
        super(new RequiredAnnotationValidator());
    }
}
