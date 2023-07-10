package com.sixkery.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 215. 数组中的第K个最大元素 medium
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * @author sixkery
 * @since 2023/7/10
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {


        Set<Integer> set = Arrays.stream(nums).boxed().sorted().collect(Collectors.toCollection(LinkedHashSet::new));

         ArrayList<Integer> list = new ArrayList<>();
        final List<Set<Integer>> sets = Collections.singletonList(set);

    }
}
