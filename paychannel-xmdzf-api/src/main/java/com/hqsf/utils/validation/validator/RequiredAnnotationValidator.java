package com.hqsf.utils.validation.validator;

import com.hqsf.utils.validation.annotation.Required;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RequiredAnnotationValidator<T extends Serializable> implements Validator<T, Required> {
    @Override
    public List<String> validate(Field field, T t, Required required) {
        String fieldName = required.value();
        if (null == fieldName || fieldName.isEmpty()) {
            fieldName = field.getName();
        }
        String validatedFailMsg = required.validatedFailMsg();
        boolean notBlank = required.notBlank();
        boolean notEmpty = required.notEmpty();
        int minSize = required.minSize();
        int maxSize = required.maxSize();
        int min = required.min();
        int max = required.max();

        List<String> msg = new ArrayList<>();
        if (null != t) {
            Class<?> fieldType = field.getType();
            //String 类型
            if (fieldType == String.class) {
                String temp = (String) t;
                if (notBlank && temp.trim().isEmpty()) {
                    msg.add(String.format("[%s]不能为空字符串", fieldName));
                }
                if (temp.length() < minSize) {
                    msg.add(String.format("[%s=%s]长度不能小于[%d]", fieldName, temp, minSize));
                }
                if (temp.length() > maxSize) {
                    msg.add(String.format("[%s=%s]长度不能大于[%d]", fieldName, temp, maxSize));
                }
            }
            if (fieldType == Collection.class) {
                Collection list = (Collection) t;
                if (notEmpty && list.isEmpty()) {
                    msg.add(String.format("[%s]集合不能为空", fieldName));
                }
            }
            if (fieldType.isArray()) {
                Object[] objects = (Object[]) t;
                if (notEmpty && objects.length > 0) {
                    msg.add(String.format("[%s]数组不能为空", fieldName));
                }
            }
            if (fieldType.isAssignableFrom(Number.class)) {
                Number number = (Number) t;
                if (number.doubleValue() < min) {
                    msg.add(String.format("[%s=%d]不能小于最小值[%d]", fieldName, number, min));
                }
                if (number.doubleValue() > max) {
                    msg.add(String.format("[%s=%d]不能大于最大值[%d]", fieldName, number, max));
                }
            }
        } else {
            msg.add(String.format("[%s]不能为空", fieldName));
        }
        //如果存在自定义提示信息
        if (!msg.isEmpty() && null != validatedFailMsg && !validatedFailMsg.isEmpty()) {
            msg.clear();
            msg.add(validatedFailMsg);
        }
        return msg;
    }

    @Override
    public Class<Required> getAnnotation() {
        return Required.class;
    }


}
