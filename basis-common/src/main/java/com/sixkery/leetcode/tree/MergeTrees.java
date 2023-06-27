package com.sixkery.leetcode.tree;

import com.sixkery.leetcode.entity.TreeNode;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 617. 合并二叉树 easy
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * @author sixkery
 * @since 2023/6/27
 */
public class MergeTrees {

    public static TreeNode solution(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);

        merged.left = solution(root1.left, root2.left);
        merged.right = solution(root1.right, root2.right);
        return merged;
    }

    public static void main(String[] args) {
        final HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null, null);
        objectObjectHashMap.put(1, null);
        objectObjectHashMap.put(2, null);
        System.out.println("objectObjectHashMap = " + objectObjectHashMap);

        final ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put(null,null);
    }
}
