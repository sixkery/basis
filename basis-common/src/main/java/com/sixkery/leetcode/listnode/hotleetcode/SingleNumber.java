package com.sixkery.leetcode.listnode.hotleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * @author sixkery
 * @since 2024/9/4
 */
public class SingleNumber {

    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }

        return 0;
    }

    /**
     * 异或运算有个重要的性质，两个相同数字异或为 0
     * @param nums 
     * @return
     */
    private static int singleNumber1(int[] nums) {
       int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans^nums[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        // test singleNumber
        int[] nums = {4, 1, 2, 1, 2};
//        final int i = singleNumber(nums);
        final int i = singleNumber1(nums);
        System.out.println("i = " + i);

    }
}
