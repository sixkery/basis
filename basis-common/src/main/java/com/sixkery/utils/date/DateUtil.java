package com.sixkery.utils.date;

import java.lang.management.ManagementFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


/**
 * 时间工具类
 *
 * @author sixkery
 * @since 2020/5/16
 */
public class DateUtil {

    private static final int TODAY = 1;
    private static final int SEVEN_DAY = 2;
    private static final int FIFTEEN = 3;

    /**
     * 时间格式化
     */
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    private static final String HOUR_PATTERN = "yyyy-MM-dd HH";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String MONTH_PATTERN = "yyyy-MM";
    private static final String YEAR_PATTERN = "yyyy";
    private static final String MINUTE_ONLY_PATTERN = "mm";


    /**
     * localDate 转 Date
     *
     * @param localDate localDate
     * @return date
     */
    public static Date toDate(LocalDate localDate) {
        return toDate(localDate.atTime(LocalTime.now(ZoneId.systemDefault())));
    }

    /**
     * LocalDateTime 转 Date
     *
     * @param localDateTime localDateTime
     * @return date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转 LocalDateTime
     *
     * @param date Date
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 获取服务器启动时间
     *
     * @return 启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    public static String startPreFix(String date) {
        return date + "00:00:00";
    }


    public static String endPreFix(String date) {
        return date + "23:23:59";
    }

}




