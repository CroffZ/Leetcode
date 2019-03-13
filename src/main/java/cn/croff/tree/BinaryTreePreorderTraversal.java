package cn.croff.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example:
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * Output: [1,2,3]
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecursively(root, result);
        return result;
    }

    /**
     * 递归实现
     *
     * @param root   根结点
     * @param result 遍历结果List
     */
    private void preorderTraversalRecursively(TreeNode root, List<Integer> result) {
        if (root == null) return;
        // 先读取根节点的值，再递归处理左子树，然后递归处理右子树
        result.add(root.val);
        preorderTraversalRecursively(root.left, result);
        preorderTraversalRecursively(root.right, result);
    }

    /**
     * 栈实现
     *
     * @param root 根结点
     * @return 遍历结果List
     */
    private List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node;
        // 先把根节点入栈
        stack.push(root);
        while (!stack.empty()) {
            node = stack.pop();
            if (node != null) {
                // 对于栈中每一个结点node，只要node不为null，就读取node的值，并依次将其右子树和左子树入栈
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}
