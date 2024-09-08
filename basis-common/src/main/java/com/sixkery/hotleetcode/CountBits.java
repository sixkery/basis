package com.sixkery.hotleetcode;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * @author sixkery
 * @since 2024/9/4
 */
public class CountBits {

    private static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // test countBits
        final int[] ans = countBits(2);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}
