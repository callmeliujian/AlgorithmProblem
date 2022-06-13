package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import common.TreeNode;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class _429_N叉树的层序遍历 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            List<Integer> item = new ArrayList<>();
            while (length > 0) {

                Node temp = deque.removeFirst();
                item.add(temp.val);
                for (Node ch : temp.children) {
                    deque.addLast(ch);
                }
                length --;
            }
            ans.add(item);
        }
        return ans;
    }

}
