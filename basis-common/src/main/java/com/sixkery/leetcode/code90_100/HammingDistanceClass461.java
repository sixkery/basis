package com.sixkery.leetcode.code90_100;

/**
 * 461. 汉明距离
 *
 * @author sixkery
 * @since 2023/5/28
 */
public class HammingDistanceClass461 {


    /**
     * 知识点：异或的运算符，符号为（^）,其主要是对两个操作数进行位的异或运算，相同取0，相反取1。即两操作数相同时，互相抵消。
     * 解法 Integer.bitCount(x ^ y) 统计二进制 1 的个数
     *
     * @param x 操作数 x
     * @param y 操作数 y
     * @return 两个操作数 1 的个数
     */
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);

    }

    public static void main(String[] args) {
        int result = hammingDistance(1, 4);
        System.out.println("result = " + result);

    }
}
