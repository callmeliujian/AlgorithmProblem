package BinaryTree;
import common.TreeNode;
import java.util.*;

public class _623_在二叉树中增加一行 {
    // 当到达第 depth - 1 层，则进行加点操作。
    // Solution2 为 Solution 的代码精简版本
    class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                TreeNode newNode = new TreeNode(val);
                newNode.left = root;
                return newNode;
            }
            int currentDepth = 1;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                if (currentDepth == depth-1) {
                    while (size > 0) {
                        size--;
                        TreeNode item = queue.removeFirst();
                        //if (item.left != null) {
                        TreeNode newNode = new TreeNode(val);
                        newNode.left = item.left;
                        item.left = newNode;
                        //}
                        //if (item.right != null) {
                        TreeNode newNode1 = new TreeNode(val);
                        newNode1.right = item.right;
                        item.right = newNode1;
                        //}
                    }
                    return root;
                }
                while (size > 0) {
                    size--;
                    TreeNode item = queue.removeFirst();
                    if (item.left != null) queue.addLast(item.left);
                    if (item.right != null) queue.addLast(item.right);
                }
                if (!queue.isEmpty()) {
                    currentDepth++;
                }
                size = queue.size();
            }
            return root;
        }
    }

    class Solution2 {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                TreeNode newNode = new TreeNode(val);
                newNode.left = root;
                return newNode;
            }
            int currentDepth = 1;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    size--;
                    TreeNode item = queue.removeFirst();
                    if (currentDepth == depth-1) {
                        TreeNode newLeftNode = new TreeNode(val);
                        newLeftNode.left = item.left;
                        item.left = newLeftNode;
                        TreeNode newRightNode = new TreeNode(val);
                        newRightNode.right = item.right;
                        item.right = newRightNode;
                    }
                    if (item.left != null) queue.addLast(item.left);
                    if (item.right != null) queue.addLast(item.right);
                }
                if (!queue.isEmpty()) {
                    currentDepth++;
                }
                size = queue.size();
            }
            return root;
        }
    }
}
