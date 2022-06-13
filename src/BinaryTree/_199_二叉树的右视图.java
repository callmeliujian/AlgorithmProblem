package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import common.TreeNode;

public class _199_二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            while (length > 0) {
                TreeNode temp = deque.removeFirst();
                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
                length--;
                if (length == 0) {
                    ans.add(temp.val);
                }
            }
        }
        return ans;
    }

}
