package com.framework.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public static String getI18NKey(Object model, String property) {
        String modelValue = ClassUtils.getShortName(model.getClass());
        modelValue = modelValue.substring(0, 1).toLowerCase() +
                modelValue.substring(1);
        return modelValue + "." + property;
    }

    public static boolean isNullOrEmpty(String string) {
        return (string == null) || ("".equals(string));
    }

}

/*
 * Location: E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name: com.framework.utils.StringUtils
 * JD-Core Version: 0.6.0
 */