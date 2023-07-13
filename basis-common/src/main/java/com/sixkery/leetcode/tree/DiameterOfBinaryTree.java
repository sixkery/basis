package com.sixkery.leetcode.tree;

import com.sixkery.leetcode.entity.TreeNode;

/**
 * 543. 二叉树的直径 easy
 *
 * @author sixkery
 * @since 2023/6/27
 */
public class DiameterOfBinaryTree {

    /**
     * 定义一个最大值
     */
    static int ans = 0;

    public static int diameterOfBinaryTree(TreeNode root) {

        depth(root);
        return ans;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树最大深度，不包含当前节点
        int L = depth(root.left);
        // 计算右子树最大深度，不包含当前节点
        int R = depth(root.right);

        // 将每个节点最大直径(左子树深度 + 右子树深度)当前最大值比较并取大者即为结果
        ans = Math.max(L + R, ans);
        // 返回当前节点的最大深度(包含了当前节点)
        // +1 目的是要包含根节点，L 或 R 只是其左右子树的深度
        return Math.max(L, R) + 1;

    }
}
