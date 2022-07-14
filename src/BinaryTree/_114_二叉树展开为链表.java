package BinaryTree;
import common.TreeNode;

//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//        展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//        展开后的单链表应该与二叉树 先序遍历 顺序相同。
//         
//
//        示例 1：
//
//
//        输入：root = [1,2,5,3,4,null,6]
//        输出：[1,null,2,null,3,null,4,null,5,null,6]
//        示例 2：
//
//        输入：root = []
//        输出：[]
//        示例 3：
//
//        输入：root = [0]
//        输出：[0]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _114_二叉树展开为链表 {
    // https://labuladong.github.io/algo/2/20/36/
    //对于一个节点 x，可以执行以下流程：
    // 1、先利用 flatten(x.left) 和 flatten(x.right) 将 x 的左右子树拉平。
    // 2、将 x 的右子树接到左子树下方，然后将整个左子树作为右子树。
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while(p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
