package com.sixkery.leetcode;

/**
 * 53. 最大子数组和
 * created by sixkery on 2022/1/13.
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        // 当前最大值
        int currentSum = 0;
        // 最终结果
        int sum = nums[0];
        for (int num : nums) {
            if (currentSum > 0) {
                currentSum += num;
            } else {
                currentSum = num;
            }
            sum = Math.max(currentSum, sum);
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        final int i = maxSubArray(nums);
        System.out.println("i = " + i);

    }


}
