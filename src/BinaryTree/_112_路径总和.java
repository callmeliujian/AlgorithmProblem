package BinaryTree;
import common.TreeNode;

//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
//
//        叶子节点 是指没有子节点的节点。
//
//         
//
//        示例 1：
//
//
//        输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//        输出：true
//        解释：等于目标和的根节点到叶节点路径如上图所示。
//        示例 2：
//
//
//        输入：root = [1,2,3], targetSum = 5
//        输出：false
//        解释：树中存在两条根节点到叶子节点的路径：
//        (1 --> 2): 和为 3
//        (1 --> 3): 和为 4
//        不存在 sum = 5 的根节点到叶子节点的路径。
//        示例 3：
//
//        输入：root = [], targetSum = 0
//        输出：false
//        解释：由于树是空的，所以不存在根节点到叶子节点的路径。
//         
//
//        提示：
//
//        树中节点的数目在范围 [0, 5000] 内
//        -1000 <= Node.val <= 1000
//        -1000 <= targetSum <= 1000
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/path-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _112_路径总和 {

    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        find(root, targetSum, 0);
        return ans;

    }

    private boolean find(TreeNode node, int targetSum, int currentSum) {
        currentSum += node.val;
        if (node.left == null && node.right == null && targetSum == currentSum) {
            ans = true;
        }
        if (node.left != null) {
            find(node.left, targetSum, currentSum);
        }
        if (node.right != null) {
            find(node.right, targetSum, currentSum);
        }
        currentSum -= node.val;
        return false;
    }


    class Solution {

        boolean ans = false;

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            findPath(root, targetSum, 0);
            return ans;
        }
        // 递归函数无返回值版本
        private void findPath(TreeNode node, int targetSum, int currentSum) {
            currentSum += node.val;
            if (currentSum == targetSum & node.left == null && node.right == null) {
                ans = true;
                return;
            }
            if (node.left != null) {
                findPath(node.left, targetSum, currentSum);
            }
            if (node.right != null) {
                findPath(node.right, targetSum, currentSum);
            }
            currentSum -= node.val;
        }

    }

    class Solution1 {
        // 有返回值 加法版本
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            return findPath(root, targetSum, root.val);
        }

        private boolean findPath(TreeNode node, int targetSum, int currentSum) {
            if (currentSum == targetSum && node.left == null && node.right == null) {
                return true;
            }
            if (node.left == null && node.right == null) {
                return false;
            }
            if (node.left != null) {
                currentSum += node.left.val;
                boolean res = findPath(node.left, targetSum, currentSum);
                currentSum -= node.left.val;
                if (res) {
                    return true;
                }
            }
            if (node.right != null) {
                currentSum += node.right.val;
                boolean res = findPath(node.right, targetSum, currentSum);
                currentSum -= node.right.val;
                if (res) {
                    return true;
                }
            }
            return false;
        }

    }

    class Solution2 {
        // 有返回值版本 减法版本
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            return findPath(root, targetSum, targetSum - root.val);
        }

        private boolean findPath(TreeNode node, int targetSum, int currentSum) {
            if (currentSum == 0 && node.left == null && node.right == null) {
                return true;
            }
            if (node.left == null && node.right == null) {
                return false;
            }
            if (node.left != null) {
                currentSum -= node.left.val;
                boolean res = findPath(node.left, targetSum, currentSum);
                currentSum += node.left.val;
                if (res) {
                    return true;
                }
            }
            if (node.right != null) {
                currentSum -= node.right.val;
                boolean res = findPath(node.right, targetSum, currentSum);
                currentSum += node.right.val;
                if (res) {
                    return true;
                }
            }
            return false;
        }

    }


}
