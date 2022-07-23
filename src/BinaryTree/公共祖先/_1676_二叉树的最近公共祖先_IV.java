package BinaryTree.公共祖先;
import common.TreeNode;
import java.util.*;

//给定一棵二叉树的根节点 root 和 TreeNode 类对象的数组（列表） nodes，返回 nodes 中所有节点的最近公共祖先（LCA）。数组（列表）中所有节点都存在于该二叉树中，且二叉树中所有节点的值都是互不相同的。
//
//        我们扩展二叉树的最近公共祖先节点在维基百科上的定义：“对于任意合理的 i 值， n 个节点 p1 、 p2、...、 pn 在二叉树 T 中的最近公共祖先节点是后代中包含所有节点 pi 的最深节点（我们允许一个节点是其自身的后代）”。一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
//
//         
//
//        示例 1:
//
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
//        输出: 2
//        解释: 节点 4 和 7 的最近公共祖先是 2。
//        示例 2:
//
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [1]
//        输出: 1
//        解释: 单个节点的最近公共祖先是该节点本身。
//
//        示例 3:
//
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4]
//        输出: 5
//        解释: 节点 7、6、2 和 4 的最近公共祖先节点是 5。
//        示例 4:
//
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [0,1,2,3,4,5,6,7,8]
//        输出: 3
//        解释: 树中所有节点的最近公共祖先是根节点。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iv
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1676_二叉树的最近公共祖先_IV {

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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            HashSet<TreeNode> nodeSet = new HashSet<>();
            for (TreeNode node : nodes) {
                nodeSet.add(node);
            }
            return lca(root, nodeSet);
        }

        private TreeNode lca(TreeNode node, HashSet<TreeNode> nodeSet) {
            if (node == null) return null;
            if (nodeSet.contains(node)) {
                return node;
            }
            TreeNode leftNode = lca(node.left, nodeSet);
            TreeNode rightNode = lca(node.right, nodeSet);
            if (leftNode != null && rightNode != null) {
                return node;
            }
            return leftNode != null ? leftNode : rightNode;
        }

    }

}
