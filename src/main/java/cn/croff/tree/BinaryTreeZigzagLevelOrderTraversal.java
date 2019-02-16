package cn.croff.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // 交替用两个栈来暂存中间结果
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        stack1.push(root);
        // flag为true时，从stack1中读取数据后存入stack2，false时相反
        boolean flag = true;
        while (true) {
            List<Integer> list = new ArrayList<>();
            if (flag) {
                if (stack1.empty()) break;
                while (!stack1.empty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    // 从左到右添加结点
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
                flag = false;
            } else {
                if (stack2.empty()) break;
                while (!stack2.empty()) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    // 从右到左添加结点
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
                flag = true;
            }
            result.add(list);
        }
        return result;
    }
}
