package BinaryTree;
import common.TreeNode;
import java.util.*;

public class _1302_层数最深叶子节点的和 {

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
        public int deepestLeavesSum(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(root);
            int sum = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                sum = 0;
                while (size > 0) {
                    size--;
                    TreeNode node = queue.removeFirst();
                    sum += node.val;
                    if (node.left != null)queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }
                size = queue.size();
            }

            return sum;
        }
    }

}
