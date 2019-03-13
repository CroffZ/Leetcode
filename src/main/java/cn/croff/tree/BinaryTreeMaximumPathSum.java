package cn.croff.tree;

/**
 * 124. Binary Tree Maximum Path Sum
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * 1
 * / \
 * 2  3
 * Output: 6
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 * -10
 * / \
 * 9 20
 * /  \
 * 15  7
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {

    private int result;

    public int maxPathSum(TreeNode root) {
        // 使用成员变量result保存最大结果，然后使用DFS遍历所有结点，依次计算并更新result
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }

    /**
     * DFS搜索最大路径和
     * @param node 搜索开始的根结点
     * @return 该节点之下的最大路径长度
     */
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        // 最大值有四个来源：root、root + 左边的某条路径、root + 右边的某条路径、root + 左边的某条路径 + 右边的某条路径
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        // 计算最大路径和并更新result
        result = Math.max(result, node.val + left + right);
        // 返回该节点之下的最大路径长度
        return node.val + Math.max(left, right);
    }
}
