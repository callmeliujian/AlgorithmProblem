package BinaryTree.BST;
import common.TreeNode;

public class _230_二叉搜索树中第K小的元素 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        // 二叉搜索树中序遍历，为递增序列
        // https://labuladong.github.io/algo/2/20/41/
        int index = 0;
        int ans = -1;
        public int kthSmallest(TreeNode root, int k) {
            traverse(root, k);
            return ans;
        }

        private void traverse(TreeNode node, int k) {
            if (node == null) return;
            traverse(node.left, k);
            index++;
            if (index == k) {
                ans = node.val;
                return;
            }

            traverse(node.right, k);
        }

    }


}