package DFS;

import common.TreeNode;

public class _543_二叉树的直径 {

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans = Math.max(left + right, ans);
        return Math.max(left,right) + 1;
    }

}
