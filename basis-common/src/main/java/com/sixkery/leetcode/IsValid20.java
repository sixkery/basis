package com.sixkery.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * created by sixkery on 2022/1/10.
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * @author sixkery
 */
public class IsValid20 {


    public static boolean isValid(String s) {

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(') {
                deque.push(')');
            } else if (item == '{') {
                deque.push('}');
            } else if (item == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || item != deque.peek()) {
                return false;
            } else {
                // 配对的弹出来
                deque.pop();
            }
        }
        return deque.isEmpty();

    }


    public static void main(String[] args) {

        boolean valid = isValid("{()}");
        System.out.println("valid = " + valid);


    }
}
