### 树

some-tree

#### 题目描述

给出两个二叉树，请写出一个判断两个二叉树是否相等的函数。

判断两个二叉树相等的条件是：两个二叉树的结构相同，并且相同的节点上具有相同的值。

```java
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // 1. 判断是否都为空
        if (p == null && q == null) {
            return true;
        }
        // 2. 判断是否一棵树为空
        if (p == null || q == null) {
            return false;
        }
        // 3. 判断值是否相等
        if (p.val != q.val) {
            return false;
        }
        // 4. 判断左右子树是否相等
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
```

1. 判断两棵树是否都为空。
2. 判断是否一棵树为空。
3. 判断值是否相等。
4. 递归判断左右子数是否相等。





maximum-depth-of-binary-tree

#### 题目描述

求给定二叉树的最大深度，

最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。

```java
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 最大深度是:左边叶子深度加一 或者右边叶子深度加一
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
```









### 字符串



#### 题目描述

integer-to-roman

请将给出的整数转化为罗马数字

保证输入数字的范围在1 到 3999之间。

```java
    public static String intToRoman(int num) {
        // 字符串对应
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        // 写的真是妙啊
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
```

