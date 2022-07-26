package BinaryTree;
import java.util.*;
import common.TreeNode;

//完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
//
//        设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
//
//        实现 CBTInserter 类:
//
//        CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
//        CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
//        CBTInserter.get_root() 将返回树的头节点。
//         
//
//        示例 1：
//
//
//
//        输入
//        ["CBTInserter", "insert", "insert", "get_root"]
//        [[[1, 2]], [3], [4], []]
//        输出
//        [null, 1, 2, [1, 2, 3, 4]]
//
//        解释
//        CBTInserter cBTInserter = new CBTInserter([1, 2]);
//        cBTInserter.insert(3);  // 返回 1
//        cBTInserter.insert(4);  // 返回 2
//        cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/complete-binary-tree-inserter
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _919_完全二叉树插入器 {

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
    class CBTInserter {
        // https://leetcode.cn/problems/complete-binary-tree-inserter/solution/by-ac_oier-t9dh/
        List<TreeNode> list = new ArrayList<>();
        int index = 0;
        public CBTInserter(TreeNode root) {
            list.add(root);
            int currentIndex = 0;
            while (currentIndex < list.size()) {
                TreeNode node = list.get(currentIndex);
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
                currentIndex++;
            }
        }

        public int insert(int val) {
            TreeNode newNode = new TreeNode(val);
            while (list.get(index).left != null && list.get(index).right != null) {
                index++;
            }
            TreeNode currentNode = list.get(index);
            if (currentNode.left == null) {
                currentNode.left = newNode;
            } else {
                currentNode.right = newNode;
            }
            list.add(newNode);
            return currentNode.val;
        }

        public TreeNode get_root() {
            return list.get(0);
        }
    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */

}
