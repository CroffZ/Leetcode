package cn.croff.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
        // 根结点入队
        queue1.offer(root);
        // queue1和queue2交替作为from和to，使用一个标记位记录
        boolean queue1ToQueue2 = true;
        while (true) {
            List<Integer> level;
            if (queue1ToQueue2) {
                level = traversal(queue1, queue2);
            } else {
                level = traversal(queue2, queue1);
            }
            // 本层遍历结果为空时表明遍历结束，退出循环
            if (level.isEmpty()) break;
            result.add(level);
            queue1ToQueue2 = !queue1ToQueue2;
        }
        return result;
    }

    /**
     * 遍历一层结点
     *
     * @param from 本层结点
     * @param to   下一层结点
     * @return 本层遍历结果
     */
    private List<Integer> traversal(Queue<TreeNode> from, Queue<TreeNode> to) {
        List<Integer> result = new ArrayList<>();
        while (!from.isEmpty()) {
            TreeNode node = from.poll();
            if (node != null) {
                result.add(node.val);
                to.offer(node.left);
                to.offer(node.right);
            }
        }
        return result;
    }
}
