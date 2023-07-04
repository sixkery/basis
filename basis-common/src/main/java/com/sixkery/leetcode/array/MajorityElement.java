package com.sixkery.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素 easy
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * @author sixkery
 * @since 2023/7/4
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int a = length / 2;
        int result = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            final Integer value = integerIntegerEntry.getValue();

            if (value > a) {
                result = integerIntegerEntry.getKey();
            }

        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};
        majorityElement(nums);
    }
}
