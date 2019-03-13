package cn.croff.tree;

/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }

    /**
     * 检查两个结点是否对称
     * @param left 左结点
     * @param right 右结点
     * @return 是否对称
     */
    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            // 左右结点都为空
            return true;
        } else if (left != null && right != null) {
            // 左右结点都非空
            return left.val == right.val && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
        } else {
            // 左右结点一个为空，一个非空
            return false;
        }
    }
}
