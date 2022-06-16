package BinaryTree;

import common.TreeNode;

import java.util.*;

public class _145_二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root,ans);
        return ans;
    }

    private void postorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        postorder(node.left,ans);
        postorder(node.right,ans);
        ans.add(node.val);
    }

    // 迭代
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.removeLast();
            ans.add(temp.val);
            if (temp.left != null) deque.addLast(temp.left);
            if (temp.right != null) deque.addLast(temp.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}
