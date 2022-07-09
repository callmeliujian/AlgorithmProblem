package BinaryTree;
import java.util.*;
import common.TreeNode;

//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//         
//
//        示例 1：
//
//
//        输入：root = [3,9,20,null,null,15,7]
//        输出：[[3],[20,9],[15,7]]
//        示例 2：
//
//        输入：root = [1]
//        输出：[[1]]
//        示例 3：
//
//        输入：root = []
//        输出：[]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _103_二叉树的锯齿形层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // 控制添加到item的顺序！
        boolean flag = true;
        while (!queue.isEmpty()) {
            Deque<Integer> item = new ArrayDeque<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                if (flag) {
                    item.addLast(node.val);
                } else {
                    item.addFirst(node.val);
                }

            }
            flag = !flag;
            ans.add(new LinkedList<Integer>(item));
        }
        return ans;
    }

}
