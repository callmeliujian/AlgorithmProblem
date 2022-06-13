package BinaryTree;

import common.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            ans++;
            while (length > 0) {
                TreeNode temp = deque.removeFirst();
                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
                length--;
            }
        }
        return ans;
    }

}
