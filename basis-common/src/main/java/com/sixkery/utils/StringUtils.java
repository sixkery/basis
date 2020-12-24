package com.sixkery.utils;

/**
 * @author sixkery
 * @date 2020/5/16
 * <p>
 * 字符串操作工具类
 */
public class StringUtils extends org.springframework.util.StringUtils {

    public static boolean isNotEmpty(String str) {
        return !org.springframework.util.StringUtils.isEmpty(str);

    }
}
