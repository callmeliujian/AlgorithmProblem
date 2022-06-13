package BinaryTree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int length = deque.size();
            while (length > 0) {
                TreeNode temp = deque.removeFirst();
                item.add(temp.val);
                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
                length--;
            }
            list.add(item);
        }
        return list;
    }

}
