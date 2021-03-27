package com.sixkery.basis.security.util;

import com.sixkery.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * redis 处理工具类
 *
 * @author: sixkery
 * @date:2021/3/22
 */
@Slf4j
@Component
public class RedisUtil {

    @Resource
    private StringRedisTemplate redisTemplate;


    //---------------------------对 key 的操作 ---------------------------------------//

    /**
     * scan 实现
     *
     * @param pattern  表达式
     * @param consumer 对迭代的 key 进行操作
     */
    public void scan(String pattern, Consumer<byte[]> consumer) {
        redisTemplate.execute((RedisConnection connection) -> {
            try (Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().count(Long.MAX_VALUE).match(pattern).build())) {
                cursor.forEachRemaining(consumer);
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                throw new ApiException(e);
            }

        });
    }

    /**
     * scan 获取符合条件的 key
     *
     * @param pattern 表达式
     * @return 条件
     */
    public Set<String> scan(String pattern) {
        Set<String> keys = new HashSet<>();
        this.scan(pattern, item -> {
            String key = new String(item, StandardCharsets.UTF_8);
            keys.add(key);
        });
        return keys;

    }

    /**
     * 通过表达式删除所有的 key
     *
     * @param pattern 表达式
     */
    public void delByPattern(String pattern) {
        Set<String> keys = this.scan(pattern);
        redisTemplate.delete(keys);
    }


}
