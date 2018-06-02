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

    /*
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        return inorderTraversalRecursive(root, new ArrayList<>());
    }

    private List<Integer> inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        result = inorderTraversalRecursive(root.left, result);
        result.add(root.val);
        result = inorderTraversalRecursive(root.right, result);
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.empty()) {
            node = stack.pop();
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                result.add(node.val);
                stack.push(node.right);
            }
        }
        return result;
    }
}
