package com.sixkery.utils;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户名验证工具类
 *
 * @author sixkery
 */
@Slf4j
public class NameUtil {

    public static final String REG_USERNAME = "^[a-zA-Z0-9_\\u4e00-\\u9fa5]{1,16}$";

    public static final String REG_MOBILE = "^[1][3,4,5,6,7,8,9][0-9]{9}$";

    public static final String REG_EMAIL = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    /**
     * 由字母、数字、下划线、中文组成，不能超过16位
     */
    private static final Pattern pUsername = Pattern.compile(REG_USERNAME);

    /**
     * 普通用户11位手机号
     * 10、11、12开头的号码已分配给特定机构
     */
    private static final Pattern pMobile = Pattern.compile(REG_MOBILE);

    /**
     * 邮箱
     * http://emailregex.com/
     */
    private static final Pattern pEmail = Pattern.compile(REG_EMAIL);

    public static boolean username(String v) {

        if (StrUtil.isBlank(v)) {
            return false;
        }
        Matcher m = pUsername.matcher(v);
        return m.matches();
    }

    public static boolean mobile(String v) {

        if (StrUtil.isBlank(v)) {
            return false;
        }
        Matcher m = pMobile.matcher(v);
        return m.matches();
    }

    public static boolean email(String v) {

        if (StrUtil.isBlank(v)) {
            return false;
        }
        Matcher m = pEmail.matcher(v);
        return m.matches();
    }
}
