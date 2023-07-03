package com.sixkery.leetcode.array;

/**
 * 283. 移动零 easy
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @author sixkery
 * @since 2023/7/3
 */
public class MoveZeroes {


    public static void moveZeroes(int[] nums) {

        // 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
        // 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            if (right < nums.length) {
                if (nums[i] != 0) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                }
                right++;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        moveZeroes(nums);
        for (int num : nums) {
            System.out.println("i = " + num);

        }

    }
}
