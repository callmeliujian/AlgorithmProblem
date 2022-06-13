package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import common.TreeNode;


public class _116_填充每个节点的下一个右侧节点指针 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) return root;
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            Node lastNode = null;
            while (length > 0) {
                Node temp = deque.removeFirst();
                if (lastNode != null) {
                    lastNode.next = temp;
                }
                lastNode = temp;
                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
                length--;
            }
        }
        return root;
    }

}
