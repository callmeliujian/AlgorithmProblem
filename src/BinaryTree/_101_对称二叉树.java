package BinaryTree;

import common.TreeNode;

public class _101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }

        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right,right.left);
        boolean isSame = outside && inside;
        return isSame;
    }

}
