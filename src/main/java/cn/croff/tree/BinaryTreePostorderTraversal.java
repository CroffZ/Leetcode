package cn.croff.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Example:
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [3,2,1]
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalRecursively(root, result);
        return result;
    }

    /**
     * 递归实现
     *
     * @param root   根结点
     * @param result 遍历结果List
     */
    private void postorderTraversalRecursively(TreeNode root, List<Integer> result) {
        if (root == null) return;
        // 先递归处理左子树，再递归处理右子树，然后读取根节点的值
        postorderTraversalRecursively(root.left, result);
        postorderTraversalRecursively(root.right, result);
        result.add(root.val);
    }

    /**
     * 栈实现
     *
     * @param root 根结点
     * @return 遍历结果List
     */
    private List<Integer> postorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current, previous = null;
        // 先把根节点入栈
        stack.push(root);
        while (!stack.empty()) {
            current = stack.pop();
            if (current == null) continue;
            if ((current.left == null && current.right == null) ||
                    (current.left != null && current.left == previous) ||
                    (current.right != null && current.right == previous)) {
                // current为叶子结点或current的子树被访问过时，可以访问current
                result.add(current.val);
            } else {
                // 否则就依次把current、current.right、current.left入栈
                stack.push(current);
                stack.push(current.right);
                stack.push(current.left);
            }
            previous = current;
        }
        return result;
    }
}
