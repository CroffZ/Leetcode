package cn.croff.tree;

/**
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Example 1:
 * Input: [1,2,3], [1,2,3]
 * Output: true
 * Example 2:
 * Input: [1,2], [1,null,2]
 * Output: false
 * Example 3:
 * Input: [1,2,1], [1,1,2]
 * Output: false
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 都为null或都不为null且值相等时才返回true，否则返回false
        if (p == null && q == null) return true;
        if (q == null || p == null || p.val != q.val) return false;
        // 对左右子树递归处理并返回结果
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
