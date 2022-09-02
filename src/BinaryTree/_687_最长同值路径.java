package BinaryTree;
import java.util.*;
import common.TreeNode;

//给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
//
//        两个节点之间的路径长度 由它们之间的边数表示。
//
//         
//
//        示例 1:
//
//
//
//        输入：root = [5,4,5,1,1,5]
//        输出：2
//        示例 2:
//
//
//
//        输入：root = [1,4,5,4,4,5]
//        输出：2
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/longest-univalue-path
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _687_最长同值路径 {
    // https://leetcode.cn/problems/longest-univalue-path/solution/zui-chang-tong-zhi-lu-jing-by-leetcode-s-hgfk/
    class Solution {
        int ans = 0;
        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left), right = dfs(root.right);
            int left1 = 0, right1 = 0;
            if (root.left != null && root.left.val == root.val) {
                left1 = left + 1;
            }
            if (root.right != null && root.right.val == root.val) {
                right1 = right + 1;
            }
            ans = Math.max(ans, left1 + right1);
            return Math.max(left1, right1);
        }

    }

}
