package com.sixkery.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author sixkery
 * @date 2020/5/17
 * <p>
 * 动态权限相关业务类
 */
public interface DynamicSecurityService {
    /**
     * 加载资源 ANT 通配符和资源对应 MAP
     *
     * @return map
     */
    Map<String, ConfigAttribute> loadDataSource();
}
