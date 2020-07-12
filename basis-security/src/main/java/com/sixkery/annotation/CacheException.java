package com.sixkery.annotation;

import java.lang.annotation.*;

/**
 * @author sixkery
 * @date 2020/4/21
 * <p>
 * 自定义注解，有该注解的缓存方法会抛异常
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
