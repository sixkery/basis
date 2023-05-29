package com.sixkery.leetcode.entity;

import lombok.Data;

/**
 * 二叉树
 * created by sixkery on 2022/3/17.
 */
@Data
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
