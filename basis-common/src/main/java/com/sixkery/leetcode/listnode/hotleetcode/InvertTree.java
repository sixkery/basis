package com.sixkery.leetcode.listnode.hotleetcode;

import com.sixkery.leetcode.entity.TreeNode;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author sixkery
 * @since 2024/9/1
 */
public class InvertTree {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);

        return root;
    }
}
