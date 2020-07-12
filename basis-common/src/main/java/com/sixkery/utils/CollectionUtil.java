package com.sixkery.utils;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author liugang
 * @date 2020/5/15
 * <p>
 * 集合工具类
 */
public class CollectionUtil extends CollectionUtils {

    /**
     * 验证集合是否为空
     *
     * @param collection 集合
     * @return boolean
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 验证集合是否不为空
     *
     * @param collection 集合
     * @return boolean
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 验证 map 是否为空
     *
     * @param map map
     * @return boolean
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 验证 map 是否不为空
     *
     * @param map map
     * @return boolean
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static void main(String[] args) {
        List<String> listA = Arrays.asList("1", "2");
        List<String> listB = Arrays.asList("1", "2", "3", "4");

        if (StringUtils.hasText("12")) {
            System.out.println("listB = " + listB);
        }

        //1、交集
        List<String> jiaoList = new ArrayList<>(listB);
        jiaoList.removeAll(listA);
        System.out.println(jiaoList);
        //输出:[3, 4]

//        //2、差集
//        List<String> chaList = new ArrayList<>(listA);
//        chaList.removeAll(listB);
//        System.out.println(chaList);
//        //输出:[1, 2]
//
//        //3、并集 (先做差集再做添加所有）
//        List<String> bingList = new ArrayList<>(listA);
//        bingList.removeAll(listB); // bingList为 [1, 2]
//        bingList.addAll(listB);  //添加[3,4,5,6]
//        System.out.println(bingList);
        //输出:[1, 2, 3, 4, 5, 6]
    }
}