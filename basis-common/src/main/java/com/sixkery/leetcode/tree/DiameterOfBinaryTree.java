package com.sixkery.leetcode.tree;

import com.sixkery.leetcode.entity.TreeNode;

/**
 * 543. 二叉树的直径 easy
 * @author sixkery
 * @since 2023/6/27
 */
public class DiameterOfBinaryTree {

    public static int diameterOfBinaryTree(TreeNode root){
        // 定义一个最大值
        int ans = 0;

        deth(root, ans);
        return ans;
    }
    public int deth(TreeNode root, int ans) {
        if (root == null) {
            return 0;
        }
        int L = deth(root.left,ans);
        int R = deth(root.right,ans);
        ans = Math.max(L+R, ans);
        

    }
}
