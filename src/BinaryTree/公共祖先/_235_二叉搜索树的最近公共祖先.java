package BinaryTree.公共祖先;
import common.TreeNode;

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//        例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//         
//
//        示例 1:
//
//        输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//        输出: 6
//        解释: 节点 2 和节点 8 的最近公共祖先是 6。
//        示例 2:
//
//        输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//        输出: 2
//        解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
//         
//
//        说明:
//
//        所有节点的值都是唯一的。
//        p、q 为不同节点且均存在于给定的二叉搜索树中。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _235_二叉搜索树的最近公共祖先 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        // https://mp.weixin.qq.com/s/njl6nuid0aalZdH5tuDpqQ?forceh5=1
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int value1 = Math.min(p.val, q.val);
            int value2 = Math.max(p.val, q.val);
            return lca(root, value1, value2);
        }

        private TreeNode lca(TreeNode node, int leftValue, int rightValue) {
            if (node == null) return null;
            if (node.val > rightValue) return lca(node.left, leftValue, rightValue);
            if (node.val < leftValue) return lca(node.right, leftValue, rightValue);
            return node;
        }

    }

}
