package BinaryTree;
import common.TreeNode;

public class _110_平衡二叉树 {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            int ans = getHeight(root);
            return ans != -1 ? true : false;
        }
        // 如果为二叉平衡树，返回当前树高，否则返回 -1
        // https://programmercarl.com/0110.平衡二叉树.html#递归
        private int getHeight(TreeNode root) {
            if (root == null) return 0;
            int leftHeight = getHeight(root.left);
            if (leftHeight == -1) {
                return -1;
            }
            int rightHeight = getHeight(root.right);
            if (rightHeight == -1) {
                return -1;
            }
            int res = 0;
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return - 1;
            } else {
                return 1 + Math.max(leftHeight, rightHeight);
            }
        }
    }

}
