package com.sixkery.leetcode;

/**
 * @author sixkery
 * @since 2025/1/7
 */
public class RemoveElement {


    public static void remove(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            } else {
                count++;
            }
        }

        System.out.println("length = " + count);

    }


    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        remove(a,2);
    }

}
