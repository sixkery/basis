package com.sixkery.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 easy
 * created by sixkery on 2022/1/10.
 *
 * @author sixkery
 */
public class TwoSum1 {

    /**
     * 暴力求解
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值的和的下标
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * hash 表求解
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值的和的下标
     */
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果存在 直接获取两个值
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            // 如果不存在存入 hash 表
            hashTable.put(nums[i], i);
        }
        return new int[]{};
    }





    public static void main(String[] args) {
//        int[] nums = {3, 3, 1};
        int[] nums = {3, 2, 4};
        int[] ints = twoSum(nums, 6);
        System.out.println("ints = " + Arrays.toString(ints));
    }

}
