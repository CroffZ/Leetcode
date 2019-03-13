package cn.croff.tree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    /**
     * 递归将有序数组转化为BST
     *
     * @param nums  有序数组
     * @param start 起始下标
     * @param end   结束下标
     * @return BST的根结点
     */
    private TreeNode convert(int[] nums, int start, int end) {
        // 递归结束条件
        if (start > end) return null;
        // 计算中间结点的下标
        int mid = start + ((end - start) / 2);
        // 构建中间结点，分别递归构建左右子树
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convert(nums, start, mid - 1);
        node.right = convert(nums, mid + 1, end);
        // 返回中间结点
        return node;
    }
}
