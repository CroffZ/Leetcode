package cn.croff.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * Input: [1,null,2,3]
 * Output: [1,3,2]
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversalRecursively(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursively(root, result);
        return result;
    }

    /**
     * 递归实现
     *
     * @param root   根结点
     * @param result 遍历结果List
     */
    private void inorderTraversalRecursively(TreeNode root, List<Integer> result) {
        if (root == null) return;
        // 先递归处理左子树，再读取根节点的值，然后递归处理右子树
        inorderTraversalRecursively(root.left, result);
        result.add(root.val);
        inorderTraversalRecursively(root.right, result);
    }

    /**
     * 栈实现
     *
     * @param root 根结点
     * @return 遍历结果List
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node;
        // 先把根节点入栈
        stack.push(root);
        while (!stack.empty()) {
            // 对于栈中每一个结点node，只要node不为null，就把node入栈并将node置为node.left，然后重复
            node = stack.pop();
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                // 直到node.left为空时，栈顶元素就是node，此时读取node的值，并将node.right入栈
                node = stack.pop();
                result.add(node.val);
                stack.push(node.right);
            }
        }
        return result;
    }
}
