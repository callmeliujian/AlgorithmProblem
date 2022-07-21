package BinaryTree;
import common.TreeNode;

public class _222_完全二叉树的节点个数 {

    class Solution2 {
        // 计算完全二叉树节点个数
        // 时间复杂度：O(logN*logN)
        // https://labuladong.github.io/algo/2/20/47/
        public int countNodes(TreeNode root) {
            TreeNode l = root, r = root;
            int hl = 0, hr = 0;
            while (l != null) {
                l = l.left;
                hl++;
            }
            while (r != null) {
                r = r.right;
                hr++;
            }
            if (hl == hr) {
                return (int)Math.pow(2,hr) - 1;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    class Solution {
        // 通用方法，任意二叉树都可以用它统计节点个数
        // 时间复杂度：O(N)
        // https://labuladong.github.io/algo/2/20/47/
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    class Solution1 {
        // 满二叉树节点个数
        // https://labuladong.github.io/algo/2/20/47/
        public int countNodes(TreeNode root) {
            int h = 0;
            while(root != null) {
                h++;
                root = root.left;
            }
            return (int)Math.pow(2,h) - 1;
        }
    }

}
