package BinaryTree;
import common.TreeNode;
import java.util.*;

public class _513_找树左下角的值 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        // 层序遍历
        public int findBottomLeftValue(TreeNode root) {
            TreeNode ans = null;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                ans = deque.peekFirst();
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
            return ans.val;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution1 {
        // 递归
        // https://programmercarl.com/0513.找树左下角的值.html#递归
        int deepest = Integer.MIN_VALUE;
        int leftValue = 0;

        public int findBottomLeftValue(TreeNode root) {
            findDeepestLeftValue(root, 0);
            return leftValue;
        }

        private void findDeepestLeftValue(TreeNode node, int pathSum) {
            if (node.left == null && node.right == null) {
                if (pathSum > deepest) {
                    deepest = pathSum;
                    leftValue = node.val;
                }
                return;
            }
            if (node.left != null) {
                pathSum++;
                findDeepestLeftValue(node.left, pathSum);
                pathSum--;
            }
            if (node.right != null) {
                pathSum++;
                findDeepestLeftValue(node.right, pathSum);
                pathSum--;
            }
        }

    }

}
