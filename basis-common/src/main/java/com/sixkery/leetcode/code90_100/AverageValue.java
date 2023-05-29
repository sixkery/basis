package com.sixkery.leetcode.code90_100;


/**
 * 2455. 可被三整除的偶数的平均值 easy
 *
 * @author sixkery
 * @since 2023/5/29
 */
public class AverageValue {
    /**
     * 返回其中可被 3 整除的所有偶数的平均值。被 3 整除的所有偶数，等价于 6 的倍数。
     *
     * @param nums 数组
     * @return 被 3 整除的所有偶数的平均值
     */
    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum = sum + num;
                cnt++;
            }
        }
        return sum == 0 ? 0 : sum / cnt;


    }
}
