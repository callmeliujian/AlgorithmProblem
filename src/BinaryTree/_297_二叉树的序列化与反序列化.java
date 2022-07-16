package BinaryTree;
import common.TreeNode;
import java.util.*;

public class _297_二叉树的序列化与反序列化 {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    String SEP = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.print(data);
        Deque<String> deque = new ArrayDeque<>();
        for (String str : data.split(SEP)) {
            deque.addLast(str);
        }
        return deserialize(deque);
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    private TreeNode deserialize(Deque<String> deque) {
        if (deque.isEmpty()) return null;
        String first = deque.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(first));
        node.left = deserialize(deque);
        node.right = deserialize(deque);
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
