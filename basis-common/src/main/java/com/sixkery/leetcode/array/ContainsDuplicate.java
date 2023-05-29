package com.sixkery.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 * @author sixkery
 */
public class ContainsDuplicate {

    /**
     * 题解零：
     * 存入hash 表，如果可以加进去，那么 hash 表中没有重复的数据
     *
     * @param nums 数组
     * @return 是否有重复
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 题解一
     * 排序 相邻两个元素相等
     *
     * @param nums 数组
     * @return 是否有重复
     */
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 题解二
     * Java 8 统计去重
     *
     * @param nums 数组
     * @return 是否有重复
     */
    public static boolean containsDuplicate2(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 1};
        final boolean b = containsDuplicate(nums);
        System.out.println("b = " + b);
    }
}
