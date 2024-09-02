package com.sixkery.leetcode.listnode.hotleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author sixkery
 * @since 2023/6/7
 */
public class MajorityElement {
    public static Integer majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int max = length / 2;
        int result = 0;
        for (Integer i : map.keySet()) {
            Integer value = map.get(i);
            if (value > max) {
                result = i;
            }
        }
        return result;


    }


    public static void main(String[] args) {
        // 写一个测试用例，测试 majorityElement 方法
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        final Integer majorityElement = majorityElement(nums);
        System.out.println("majorityElement = " + majorityElement);

    }
}
