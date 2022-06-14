package BinaryTree;

import common.TreeNode;

public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}
