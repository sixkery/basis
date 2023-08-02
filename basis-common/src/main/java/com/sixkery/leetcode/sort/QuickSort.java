package com.sixkery.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sixkery
 * @since 2023/8/2
 */
public class QuickSort {

    public static void quickSort(int[] nums, int i, int j) {
        // 只剩一个元素直接返回
        if (i >= j) {
            return;
        }
        // 选择一个基准数
        int val = nums[i];
        int l = i;
        int r = j;
        while (l < r) {
            while (l < r && nums[r] > val) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }

            while (l < r && nums[r] < val) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }

        }
        nums[l] = val;
        quickSort(nums, i, l - 1);
        quickSort(nums, l + 1, j);
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
