package 树;
import common.TreeNode;

public class _99_恢复二叉搜索树 {
    // 前一个节点
    TreeNode prev;
    // 第一个错误节点
    TreeNode first;
    // 第二个错误节点
    TreeNode second;

    public void recoverTree(TreeNode root) {
        findWrongNodes(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void findWrongNodes(TreeNode root) {
        if (root == null)
            return;
        findWrongNodes(root.left);
        // 出现了逆序对
        if (prev != null && prev.val > root.val) {
            // 第二个错误节点：最后一个逆序对众较小的那个节点
            second = root;
            if (first != null)
                return;
            first = prev;
        }

        prev = root;
        findWrongNodes(root.right);
    }

}
