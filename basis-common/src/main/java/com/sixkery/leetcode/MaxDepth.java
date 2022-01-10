package com.sixkery.leetcode;


/**
 * 括号的最大嵌套深度
 */
public class MaxDepth {

    public static int maxDepth(String s) {

        int result = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(') {
                current++;
            } else if (item == ')') {
                current--;
            }
            result = Math.max(result, current);
        }
        return result;
    }

    public static void main(String[] args) {
//        int i = maxDepth("1");  // 0
//        int i = maxDepth("(1+(2*3)+((8)/4))+1");  // 3
        int i = maxDepth("(1)+((2))+(((3)))");  // 3
        System.out.println("i = " + i);

    }
}
