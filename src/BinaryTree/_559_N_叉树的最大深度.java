package BinaryTree;
import java.util.*;

public class _559_N_叉树的最大深度 {

    class Solution {
        // 递归
        // https://programmercarl.com/0104.二叉树的最大深度.html#迭代法
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int maxD = 0;
            for (Node item : root.children) {
                int depth = maxDepth(item);
                maxD = Math.max(maxD, depth);
            }
            return 1 + maxD;
        }
    }

    class Solution1 {
        // 遍历
        // https://programmercarl.com/0104.二叉树的最大深度.html#迭代法
        public int maxDepth(Node root) {
            int ans = 0;
            if (root == null) return ans;
            Deque<Node> deque = new LinkedList<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                ans++;
                int size = deque.size();
                while (size > 0) {
                    size--;
                    Node item = deque.removeFirst();
                    for (Node n : item.children) {
                        deque.addLast(n);
                    }
                }
                size = deque.size();
            }
            return ans;
        }
    }

}
