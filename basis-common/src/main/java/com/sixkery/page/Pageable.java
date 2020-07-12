package com.sixkery.page;

import lombok.Data;

/**
 * 控制器接收的分页参数
 *
 * @author sixkery
 * @date 2020/6/27
 */
@Data
public class Pageable {
    /**
     * 页码
     */
    private int page;

    /**
     * 每页条数,默认八条
     */
    private int size = 8;

    /**
     * 排序字段 example: id desc
     */
    private String sort;

    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 最大深度是左边叶子深度加一或者右边叶子深度加一
     *
     * @param root 树
     * @return 最大深度
     */
    public static int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {            // 递归中止条件
            return 0;
        }
        int m = maxDepth(root.left);   // 取左边叶子的最大深度
        int n = maxDepth(root.right);  // 取右边叶子的最大深度

        return (Math.max(m, n)) + 1;
    }
}



