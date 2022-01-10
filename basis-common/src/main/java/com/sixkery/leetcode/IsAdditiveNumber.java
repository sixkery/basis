package com.sixkery.leetcode;

/**
 * 累加数
 * created by sixkery in 2022/1/10.
 */
public class IsAdditiveNumber {

    public static boolean isAdditiveNumber(String num) {
        int length = num.length();
        for (int i = 0; i < length - 2; i++) {
            int one = Integer.parseInt(String.valueOf(num.charAt(i)));
            int two = Integer.parseInt(String.valueOf(num.charAt(i + 1)));
            int three = Integer.parseInt(String.valueOf(num.charAt(i + 2)));
            if (one + two != three) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

//        boolean additiveNumber = isAdditiveNumber("112358"); // true
        boolean additiveNumber = isAdditiveNumber("199100199");
        System.out.println("additiveNumber = " + additiveNumber);
    }
}
