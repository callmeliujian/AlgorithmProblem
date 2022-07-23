package BinaryTree;

import common.TreeNode;
import java.util.*;

public class _104_二叉树的最大深度 {

    class Solution1 {
        public int maxDepth(TreeNode root) {
            // 根节点的高度就是二叉树的最大深度
            // 前序遍历求深度，后续遍历求高度
            // https://programmercarl.com/0104.二叉树的最大深度.html#递归法
            if (root == null) return 0;
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }

    class Solution2 {
        // 前序遍历求根节点最大深度。
        // https://programmercarl.com/0104.二叉树的最大深度.html#递归法
        int mostd = Integer.MIN_VALUE;
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            deepest(root,1);
            return mostd;
        }

        private void deepest(TreeNode root, int path) {
            mostd = mostd > path ? mostd : path;
            if (root.left == null && root.right == null) {
                return;
            }
            if (root.left != null) {
                path++;
                deepest(root.left, path);
                path--;
            }
            if (root.right != null) {
                path++;
                deepest(root.right, path);
                path--;
            }
        }
    }

    class Solution {
        // 层序遍历解法，有几层就是最大深度
        public int maxDepth(TreeNode root) {
            int ans = 0;
            if (root == null) return ans;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                ans++;
                while (size > 0) {
                    size--;
                    TreeNode node = deque.removeFirst();
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
                size = deque.size();
            }
            return ans;
        }
    }

}
