package com.jaysunxl.scaffold.util;

import com.google.common.base.CaseFormat;

import java.util.Locale;

/**
 * @Description
 * @Author JaySunXl
 * @Version 1.0.0
 * @Date 2022/12/7
 */
public class StringUtils {

    /**
     * 字符串小写
     *
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        return str.toLowerCase(Locale.ROOT);
    }

    /**
     * 非驼峰式转换为驼峰式
     *
     * @param str
     * @return
     */
    public static String toLowerCamel(String str) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, str);
    }

    /**
     * 非驼峰式转换为驼峰式
     *
     * @param str
     * @return
     */
    public static String toLowerCamel1(String str) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, str);
    }

    /**
     * 非驼峰式转换为驼峰式
     *
     * @param str
     * @return
     */
    public static String toLowerCamel2(String str) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);//testData
    }

    /**
     * 非驼峰式转换为驼峰式
     *
     * @param str
     * @return
     */
    public static String toLowerCamel3(String str) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str);//testData
    }
}
