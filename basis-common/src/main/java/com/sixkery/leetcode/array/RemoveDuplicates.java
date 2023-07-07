package com.sixkery.leetcode.array;

/**
 * @author sixkery
 * @since 2023/7/5
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast - 1];
                slow++;
            }
        }
        nums[slow + 1] = nums[nums.length-1];
        return slow + 1;


    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2};
        removeDuplicates(nums);
    }
}
