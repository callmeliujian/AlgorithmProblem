package BinaryTree;

import common.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _111_二叉树的最小深度 {

    // 只有当左右孩子都为空的时候，才说明遍历的最低点了
    public int minDepth(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            ans++;
            while (length > 0) {
                TreeNode temp = deque.removeFirst();
                if (temp.left == null && temp.right == null) {
                    return ans;
                }
                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
                length--;
            }
        }
        return ans;
    }

}
