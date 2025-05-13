/*
 * 给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
/**
 * Definition for a binary tree node.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
};

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if (root.left == null) return rightMinDepth + 1;
        if (root.right == null) return leftMinDepth + 1;
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }
}