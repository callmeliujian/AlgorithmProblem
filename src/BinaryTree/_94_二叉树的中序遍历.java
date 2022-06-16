package BinaryTree;

import common.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }

    private void inorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);
    }

}
