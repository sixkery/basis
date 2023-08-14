package com.sixkery.leetcode.String;

/**
 * @author sixkery
 * @since 2023/8/14
 */
public class TestParams {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("n 的初始值为：" + n);
        add(n);
        System.out.println("n 的最终值为：" + n);
    }
    public static void add(int n) {
        n = n + 1;
        System.out.println("add 方法的值 = " + n);
    }
}
