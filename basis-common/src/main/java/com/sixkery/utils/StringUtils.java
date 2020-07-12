package com.sixkery.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate beforeDay = now.minus(1, ChronoUnit.DAYS);
        LocalDate sevenDays = now.minus(7, ChronoUnit.DAYS);
        LocalDate fifteenDays = now.minus(15, ChronoUnit.DAYS);
        LocalDate thirtyDays = now.minus(30, ChronoUnit.DAYS);
    }
}
