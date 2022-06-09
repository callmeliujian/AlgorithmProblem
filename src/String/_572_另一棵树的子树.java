package String;
import common.TreeNode;
// https://leetcode-cn.com/problems/subtree-of-another-tree/
// 二叉树序列化

//给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
//
//        二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
//
//         
//
//        示例 1：
//
//
//        输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//        输出：true
//        示例 2：
//
//
//        输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//        输出：false

public class _572_另一棵树的子树 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return false;
        return postSerialize(root).contains(postSerialize(subRoot));
    }
    // 利用后序遍历的方式进行序列化
    private String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(root, sb);
        return sb.toString();
    }

    private void postSerialize(TreeNode node, StringBuilder sb) {
        if (node.left == null) {
            sb.append("#!");
        } else  {
            postSerialize(node.left, sb);
        }
        if (node.right == null) {
            sb.append("#!");
        } else  {
            postSerialize(node.right, sb);
        }
        sb.append(node.val).append("!");
    }

}
