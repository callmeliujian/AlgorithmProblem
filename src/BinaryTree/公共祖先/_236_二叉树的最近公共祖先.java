package BinaryTree.公共祖先;

import common.TreeNode;

public class _236_二叉树的最近公共祖先 {
    // https://mp.weixin.qq.com/s/njl6nuid0aalZdH5tuDpqQ?forceh5=1
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p.val, q.val);
    }

    private TreeNode lca(TreeNode root, int a, int b) {
        if (root == null) return null;
        // 此判断在前中后序都行
        // 前绪
        if (root.val == a || root.val == b) {
            return root;
        }
        TreeNode left = lca(root.left, a, b);
        // 中序
        //if (root.val == a || root.val == b) {
        //  return root;
        //}
        TreeNode right = lca(root.right, a, b);
        // 后序
        //if (root.val == a || root.val == b) {
        //  return root;
        //}
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    //去以 root 为根节点的二叉树中查找p、q的最近公共祖先
    //1. 如果p、q同时存在于这科二叉树中，就能成功返回它们的最近公共祖先。
    //2. 如果p、q都不存在于这颗二叉树中，返回null。
    //3. 如果只有p存在于这棵二叉树中，返回p。
    //4. 如果只有q存在于这棵二叉树中，返回q。

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 去以root.left为根节点的二叉树中查找p、q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 去以root.right为根节点的二叉树中查找p、q的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }
}
