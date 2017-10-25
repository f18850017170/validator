package com.hqsf.utils.sign;

import com.hqsf.utils.MessageDigestUtils;
import com.hqsf.utils.SimpleReflectionUtils;
import com.hqsf.utils.sign.annotation.SignFieldAlias;
import com.hqsf.utils.sign.annotation.SignIgnore;
import com.hqsf.utils.sign.convert.Converter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsSignContext<T extends SignInfoBuild> implements SignContext<T> {
    /**
     * 提供类型自定义处理方案
     */
    protected Map<Class, Converter> map = new HashMap<>();

    public AbsSignContext(Converter... converters) {
        if (null != converters){
            for (Converter converter : converters) {
                map.put(converter.getTargetClass(), converter);
            }
        }
    }

    /**
     * 指定加密方式
     * @return
     */
    public abstract MessageDigestUtils.DigestType signType();

    /**
     * 根据键值对map 构建加密字符串
     * @param fields
     * @param t
     * @return
     */
    public abstract String buildSignData(Map<String, String> fields,T t);

    @Override
    public String sign(T t) throws IllegalArgumentException {
        return sign(t, null != t ? t.getClass() : Object.class);
    }

    @Override
    public String sign(T t, Class<?> superClass) throws IllegalArgumentException {
        Map<String, String> fields = fieldsBuild(t, superClass);
        String signData = buildSignData(fields,t);
        t.setKeyValueData(signData);
        String digest = MessageDigestUtils.digest(signData, signType(), Charset.forName("UTF-8"));
        t.setSign(digest);
        return digest;
    }

    /**
     * 构建需要加签的字段
     * 1、排除使用了忽略注解的SignIgnore
     * 2、使用别名的注解SignFieldAlias
     *
     * @param t
     * @param superClass
     * @return
     */
    protected Map<String, String> fieldsBuild(Object t, Class<?> superClass) {
        final Map<String, String> result = new HashMap<>();
        final Object tempObj = t;
        SimpleReflectionUtils.iterateAccessibleItem(tempObj, superClass, new SimpleReflectionUtils.AbsFieldAccOpInvoke() {

            @Override
            public void invoke(Field field, Object tempObj, Class<?> tempClass) {
                if (!Modifier.isStatic(field.getModifiers())){
                    Object fieldValue = SimpleReflectionUtils.getFieldValue(field, tempObj);
                    if (null != fieldValue) {
                        SignIgnore annotation = field.getAnnotation(SignIgnore.class);
                        if (null == annotation) {
                            SignFieldAlias alias = field.getAnnotation(SignFieldAlias.class);
                            String fieldName = null != alias ? alias.value() : field.getName();
                            Converter converter = map.get(fieldValue.getClass());
                            if (null != converter) {
                                result.put(fieldName, converter.convert(fieldValue));
                            } else {
                                result.put(fieldName, String.valueOf(fieldValue));
                            }
                        }
                    }
                }
            }
        });
        return result;
    }
}
