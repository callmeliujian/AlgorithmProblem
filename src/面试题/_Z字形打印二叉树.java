package 面试题;

import java.util.Stack;

public class _Z字形打印二叉树 {

    /** 初始化二叉树结构 */
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        TreeNode (int value) {
            this.value = value;
        }
    }

    public TreeNode init() {
        TreeNode node15 = new TreeNode(15); // 节点15

        TreeNode node8 = new TreeNode(8); // 节点15下的左节点8
        node15.left = node8;

        TreeNode node3 = new TreeNode(3); // 节点8下的左节点3
        node8.left = node3;

        TreeNode node1 = new TreeNode(1); // 节点3下的左节点1
        node3.left = node1;

        TreeNode node4 = new TreeNode(4); // 节点3下的右节点4
        node3.right = node4;

        TreeNode node6 = new TreeNode(6); // 节点8下的右节点6
        node8.right = node6;

        TreeNode node5 = new TreeNode(5); // 节点6下的左节点5
        node6.left = node5;

        TreeNode node7 = new TreeNode(7); // 节点6下的右节点7
        node6.right = node7;

        TreeNode node24 = new TreeNode(24); // 节点15下的右节点24
        node15.right = node24;

        TreeNode node20 = new TreeNode(20); // 节点24下的左节点20
        node24.left = node20;

        TreeNode node18 = new TreeNode(18); // 节点20下的左节点18
        node20.left = node18;

        TreeNode node21 = new TreeNode(21); // 节点20下的右节点21
        node20.right = node21;

        TreeNode node30 = new TreeNode(30); // 节点24下的右节点30
        node24.right = node30;

        TreeNode node28 = new TreeNode(28); // 节点30下的左节点28
        node30.left = node28;

        TreeNode node35 = new TreeNode(35); // 节点30下的右节点35
        node30.right = node35;

        // 返回根节点
        return node15;
    }

    public void printZTree(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> oddStack = new Stack<>(); // 奇数栈
        Stack<TreeNode> evenStack = new Stack<>(); // 偶数栈
        int line = 1; // 第一行
        oddStack.push(root); // 跟节点第一行
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            if (line%2 == 1) {
                // 奇数行
                while (!oddStack.isEmpty()) {
                    TreeNode tempNode = oddStack.pop();
                    System.out.print(tempNode.value + ",");
                    if (tempNode.left != null) {
                        evenStack.push(tempNode.left); //偶数行左子节点先进栈，栈的特性 先进后出
                    }
                    if (tempNode.right != null) {
                        evenStack.push(tempNode.right); //偶数行右子节点后进栈
                    }
                }
            } else  {
                // 偶数行
                while (!evenStack.isEmpty()) {
                    TreeNode tempNode = evenStack.pop();
                    System.out.print(tempNode.value + ",");
                    if (tempNode.right != null) {
                        oddStack.push(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        oddStack.push(tempNode.left);
                    }
                }
            }
            line++;
        }
    }

    public static  void main(String[] args) {
        _Z字形打印二叉树 tree = new _Z字形打印二叉树();
        TreeNode root = tree.init();
        tree.printZTree(root);
    }


}
