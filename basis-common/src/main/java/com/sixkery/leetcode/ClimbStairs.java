package com.sixkery.leetcode;

/**
 * 70. 爬楼梯
 * created by sixkery on 2022/1/14.
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];

    }

    public static void main(String[] args) {

    }
}
