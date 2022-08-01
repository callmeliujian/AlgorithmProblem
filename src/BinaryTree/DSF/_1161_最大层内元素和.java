package BinaryTree.DSF;
import common.TreeNode;
import java.util.*;

//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//
//        请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
//
//         
//
//        示例 1：
//
//
//
//        输入：root = [1,7,0,7,-8,null,null]
//        输出：2
//        解释：
//        第 1 层各元素之和为 1，
//        第 2 层各元素之和为 7 + 0 = 7，
//        第 3 层各元素之和为 7 + -8 = -1，
//        所以我们返回第 2 层的层号，它的层内元素之和最大。
//        示例 2：
//
//        输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//        输出：2
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1161_最大层内元素和 {

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
        public int maxLevelSum(TreeNode root) {
            int ans = 1;
            int maxSum = Integer.MIN_VALUE;
            int level = 1;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int sum = 0;
                while (size > 0) {
                    size--;
                    TreeNode item = queue.removeFirst();
                    sum += item.val;
                    if (item.left != null) {
                        queue.addLast(item.left);
                    }
                    if (item.right != null) {
                        queue.addLast(item.right);
                    }
                }
                if (sum > maxSum) {
                    ans = level;
                    maxSum = sum;
                }
                level++;
                size = queue.size();
            }
            return ans;
        }
    }

}
