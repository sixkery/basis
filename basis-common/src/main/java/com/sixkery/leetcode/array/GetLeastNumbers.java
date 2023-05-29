package com.sixkery.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最小的 K 个数
 * 解题思路：先排序，再获取
 * created by sixkery on 2022/3/27.
 * @author sixkery
 */
public class GetLeastNumbers {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        Arrays.sort(input);
        if (k < 1) {
            return new ArrayList<>();
        }
        ArrayList<Integer> objects = new ArrayList<>();
        for (int i : input) {
            objects.add(i);
        }
        return new ArrayList<>(objects.subList(0, k));


    }


    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        final ArrayList<Integer> integers = GetLeastNumbers_Solution(nums, 4);
        System.out.println("integers = " + integers);


    }
}

