package com.sixkery.leetcode.tree;

import com.sixkery.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历 medium
 *
 * @author sixkery
 * @since 2023/7/13
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                temp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(temp);
        }

        return res;


    }
}
