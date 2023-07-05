package com.sixkery.leetcode.array;

import java.util.Stack;

/**
 * 739. 每日温度 easy
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * @author sixkery
 * @since 2023/7/5
 */
public class DailyTemperatures {

    /**
     * 超时了
     * @param temperatures 温度数组
     * @return 结果
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }

            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] temperatures) {

        int length = temperatures.length;
        int[] result = new int[length];
         Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {

            while (stack.isEmpty() && stack.peek() > temperatures[i]) {
                 Integer pop = stack.pop();
                result[i] = i - pop;
            }
            stack.push(i);
        }
        return result;
    }

}
