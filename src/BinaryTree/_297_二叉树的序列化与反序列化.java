package BinaryTree;
import common.TreeNode;
import java.util.*;

// 该问题可以使用前序遍历，后续遍历，层序遍历解法，但是无法使用中序遍历解法，因为无法找到跟节点


//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
//
//示例 1：
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
//
//示例 2：
//输入：root = []
//输出：[]
//
//示例 3：
//输入：root = [1]
//输出：[1]
//
//示例 4：
//输入：root = [1,2]
//输出：[1,2]
//
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/serialize-and-deserialize-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

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
    // 前序遍历
    // https://mp.weixin.qq.com/s/DVX2A1ha4xSecEXLxW_UsA
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
        // 前续遍历一定要先创建左子树
        // 后续遍历一定要先创建右子树
        node.left = deserialize(deque);
        node.right = deserialize(deque);
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Codec1 {
     // 后续遍历解法
    String NULL = "#";
    String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        String ans = sb.toString();
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        Deque<String> deque = new ArrayDeque<>();
        for (String item : data.split(SEP)) {
            deque.addLast(item);
        }
        return deserialize(deque);
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        serialize(node.left, sb);
        serialize(node.right, sb);
        sb.append(node.val).append(SEP);
    }

    private TreeNode deserialize(Deque<String> deque) {
        if (deque.isEmpty()) return null;
        String item = deque.removeLast();
        if (item.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(item));
        // 后续遍历一定要先创建右子树
        node.right = deserialize(deque);
        node.left = deserialize(deque);
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 层序
class Codec2 {
    String NULL = "NULL";
    String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode item = deque.removeFirst();
            if (item == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(item.val).append(SEP);
            deque.addLast(item.left);
            deque.addLast(item.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("NULL,")) return null;
        String[] nodeArray = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodeArray[0]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        for (int i = 1; i < nodeArray.length; ) {
            TreeNode item = deque.removeFirst();
            String arrayItem = nodeArray[i];
            if (arrayItem.equals(NULL)) {

            } else {
                TreeNode node = new TreeNode(Integer.parseInt(arrayItem));
                item.left = node;
                deque.addLast(node);
            }
            i++;
            String arrayItem1 = nodeArray[i];
            if (arrayItem1.equals(NULL)) {

            } else {
                TreeNode node = new TreeNode(Integer.parseInt(arrayItem1));
                item.right = node;
                deque.addLast(node);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
