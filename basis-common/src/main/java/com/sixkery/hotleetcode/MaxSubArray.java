package com.sixkery.hotleetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * @author sixkery
 * @since 2024/9/12
 */
@Slf4j
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        // 定义 maxSum 变量，记录连续最大子数组和
        int maxSum = nums[0];

        // 定义 cur 变量，记录当前子数组的和
        int cur = 0;
        for (int num : nums) {
            cur = Math.max(num, cur + num);
            maxSum = Math.max(cur, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        final int i = maxSubArray(nums);
        log.info("i = " + i);
    }
}
