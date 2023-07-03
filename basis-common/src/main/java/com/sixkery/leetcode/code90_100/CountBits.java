package com.sixkery.leetcode.code90_100;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * @author sixkery
 * @since 2023/7/3
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.bitCount(i);
        }

        return result;
    }
}
