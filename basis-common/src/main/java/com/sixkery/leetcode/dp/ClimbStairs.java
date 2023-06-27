package com.sixkery.leetcode.dp;

/**
 * 70. 爬楼梯
 * 爬第 n 阶楼梯用的方法等于爬 n-1 阶加上 n-2 阶楼梯的方法之和
 * created by sixkery on 2022/1/14.
 * @author sixkery
 */
public class ClimbStairs {

    public static int climbStairs(int n) {
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
        final int i = climbStairs(5);
        System.out.println("i = " + i);

    }
}
