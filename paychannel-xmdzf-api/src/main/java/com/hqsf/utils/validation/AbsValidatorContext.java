package com.hqsf.utils.validation;

import com.hqsf.utils.MapOptionUtils;
import com.hqsf.utils.SimpleReflectionUtils;
import com.hqsf.utils.validation.annotation.OnCondition;
import com.hqsf.utils.validation.validator.ValidateCondition;
import com.hqsf.utils.validation.validator.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public abstract class AbsValidatorContext implements ValidatorContext {
    private Map<Class<Annotation>, Validator> validatorMap = new HashMap<>();

    public AbsValidatorContext(Validator... validators) {
        if (null != validators) {
            for (Validator validator : validators) {
                if (validator.getAnnotation() != OnCondition.class) {
                    validatorMap.put(validator.getAnnotation(), validator);
                }
            }
        }
    }

    @Override
    public List<String> validate(Object t) throws IllegalArgumentException {
        return validate(t, null != t ? t.getClass() : Object.class);
    }

    @Override
    public List<String> validate(Object t, Class<? extends Object> superClass) throws IllegalArgumentException {
        Map<FieldInfo, List<ValidatorInfo>> fieldInfoListMap = buildFieldValidator(t, superClass);
        List<String> result = new ArrayList<>();
        if (null != fieldInfoListMap) {
            for (Map.Entry<FieldInfo, List<ValidatorInfo>> entry : fieldInfoListMap.entrySet()) {
                for (ValidatorInfo validatorInfo : entry.getValue()) {
                    FieldInfo key = entry.getKey();
                    List<String> temp = validatorInfo.getValidator().validate(key.getField(), key.getValue(), validatorInfo.getAnnotation());
                    if (!temp.isEmpty()) {
                        result.addAll(temp);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 获取field 与校验器映射关系
     *
     * @param t
     * @param superClass
     * @return
     */
    private Map<FieldInfo, List<ValidatorInfo>> buildFieldValidator(Object t, Class<? extends Object> superClass) {
        final Object tempObj = t;
        final Map<FieldInfo, List<ValidatorInfo>> map = new HashMap<>();
        SimpleReflectionUtils.iterateAccessibleItem(tempObj, superClass, new SimpleReflectionUtils.AbsFieldAccOpInvoke() {

            @Override
            public void invoke(Field tempClassField, Object tempObj, Class<?> tempClass) {
                if (!Modifier.isStatic(tempClassField.getModifiers())) {
                    Annotation[] declaredAnnotations = tempClassField.getDeclaredAnnotations();
                    if (null != declaredAnnotations && declaredAnnotations.length > 0) {
                        OnCondition annotation = tempClassField.getAnnotation(OnCondition.class);
                        try {
                            if (!onConditionCheck(tempObj, annotation)) {
                                return;
                            }
                        } catch (IllegalAccessException | InstantiationException e) {
                            throw new IllegalArgumentException(String.format("字段[%s]条件注解使用错误，请确认", tempClassField.getName()));
                        }
                        Object fieldValue = SimpleReflectionUtils.getFieldValue(tempClassField, tempObj);
                        FieldInfo fieldInfo = new FieldInfo(tempClassField, fieldValue);
                        for (Annotation declaredAnnotation : declaredAnnotations) {
                            Validator validator = validatorMap.get(declaredAnnotation.annotationType());
                            if (null != validator) {
                                MapOptionUtils.add(map, fieldInfo, new ValidatorInfo(declaredAnnotation, validator));
                            }
                        }
                    }
                }
            }
        });
        return map;
    }

    /**
     * 条件判断
     *
     * @param t
     * @param annotation
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private boolean onConditionCheck(Object t, OnCondition annotation) throws IllegalAccessException, InstantiationException {
        if (null != annotation) {
            Class<? extends ValidateCondition>[] classes = annotation.value();
            for (Class<? extends ValidateCondition> temp : classes) {
                ValidateCondition validateCondition = temp.newInstance();
                if (!validateCondition.condition(t)) return false;
            }
        }
        return true;
    }

    /**
     * 校验器信息
     */
    public static class ValidatorInfo {
        private Annotation annotation;
        private Validator validator;

        public ValidatorInfo(Annotation annotation, Validator validator) {
            this.annotation = annotation;
            this.validator = validator;
        }

        public Annotation getAnnotation() {
            return annotation;
        }

        public Validator getValidator() {
            return validator;
        }
    }

    /**
     * 字段信息
     */
    public static class FieldInfo {
        public FieldInfo(Field field, Object value) {
            this.field = field;
            this.value = value;
        }

        private Object value;
        private Field field;

        public Object getValue() {
            return value;
        }

        public Field getField() {
            return field;
        }
    }
}
