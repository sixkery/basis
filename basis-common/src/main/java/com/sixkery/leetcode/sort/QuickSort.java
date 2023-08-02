package com.sixkery.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sixkery
 * @since 2023/8/2
 */
public class QuickSort {

    public static void quickSort(int[] nums, int left, int right) {
        // 只剩一个元素直接返回
        if (left >= right) {
            return;
        }
        // 选择一个基准数
        int key = nums[left];
        int l = left;
        int r = right;
        while (l != r) {
            // 左边移动
            while (l < r && nums[r] >= key) {
                r--;
            }
            // 右边移动
            while (l < r && nums[l] <= key) {
                l++;
            }
            // 交换位置
            if (l < r) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
            }
        }
        // 交换基准位
        nums[left] = nums[l];
        nums[l] = key;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt(100) + 1;
        }

        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));


    }
}
