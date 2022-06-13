package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _117_填充每个节点的下一个右侧节点指针_II {

    class Node {
        public int val;
        public _116_填充每个节点的下一个右侧节点指针.Node left;
        public _116_填充每个节点的下一个右侧节点指针.Node right;
        public _116_填充每个节点的下一个右侧节点指针.Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, _116_填充每个节点的下一个右侧节点指针.Node _left, _116_填充每个节点的下一个右侧节点指针.Node _right, _116_填充每个节点的下一个右侧节点指针.Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public _116_填充每个节点的下一个右侧节点指针.Node connect(_116_填充每个节点的下一个右侧节点指针.Node root) {
        if (root == null) return root;
        Deque<_116_填充每个节点的下一个右侧节点指针.Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            _116_填充每个节点的下一个右侧节点指针.Node lastNode = null;
            while (length > 0) {
                _116_填充每个节点的下一个右侧节点指针.Node temp = deque.removeFirst();
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
