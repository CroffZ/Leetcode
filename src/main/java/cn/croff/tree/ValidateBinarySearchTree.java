package cn.croff.tree;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTRecursively(root, null, null);
    }

    /**
     * 递归遍历确定是否为BST
     *
     * @param node 检测的起始结点
     * @param low  结点取值下限
     * @param high 结点取值上限
     * @return 是否为BST
     */
    private boolean isValidBSTRecursively(TreeNode node, Integer low, Integer high) {
        // 确定node的值在low与high之间
        if (low != null && node.val <= low) return false;
        if (high != null && node.val >= high) return false;
        // 递归比较node的左子树和右子树的值，并调整low和high的值
        return (node.left == null || isValidBSTRecursively(node.left, low, node.val))
                && (node.right == null || isValidBSTRecursively(node.right, node.val, high));
    }

    /**
     * 根据中序遍历结果确定是否为BST
     *
     * @param root 二叉树的根结点
     * @return 是否为BST
     */
    private boolean isValidBSTByInorderTraversal(TreeNode root) {
        TreeNode previous = null;
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
                // 直到node.left为空时，栈顶元素就是node，此时将node的值与previous的值比较大小，并将node.right入栈
                node = stack.pop();
                if (previous != null && node.val <= previous.val) return false;
                previous = node;
                stack.push(node.right);
            }
        }
        return true;
    }
}
