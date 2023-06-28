package com.sixkery.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 448. 找到所有数组中消失的数字 easy
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，
 * 并以数组的形式返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * @author sixkery
 * @since 2023/6/28
 */
public class FindDisappearedNumbers {


    public static List<Integer> findDisappearedNumbers(int[] nums) {

        // hash 表存入数据 1-n 放入 hash 表 能放入 表示缺失的
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (set.add(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        final List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }
}
