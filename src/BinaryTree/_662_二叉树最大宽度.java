package BinaryTree;
import common.TreeNode;
import java.util.*;

//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
//
//        树的 最大宽度 是所有层中最大的 宽度 。
//
//        每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
//
//        题目数据保证答案将会在  32 位 带符号整数范围内。
//
//         
//
//        示例 1：
//
//
//        输入：root = [1,3,2,5,3,null,9]
//        输出：4
//        解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
//        示例 2：
//
//
//        输入：root = [1,3,2,5,null,null,9,6,null,7]
//        输出：7
//        解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
//        示例 3：
//
//
//        输入：root = [1,3,2,5]
//        输出：2
//        解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/maximum-width-of-binary-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _662_二叉树最大宽度 {
    // https://leetcode.cn/problems/maximum-width-of-binary-tree/solution/er-cha-shu-zui-da-kuan-du-by-leetcode-so-9zp3/
    // bfs
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            HashMap<TreeNode, Integer> map = new HashMap<>();
            Deque<TreeNode> list = new LinkedList<>();
            list.add(root);
            map.put(root,1);
            int ans = Integer.MIN_VALUE;
            while (!list.isEmpty()) {
                int size = list.size();
                int start = map.get(list.peek());
                int end = 0;
                while (size > 0) {
                    TreeNode node = list.removeFirst();
                    int num = map.get(node);
                    if (node.left != null) {
                        list.add(node.left);
                        map.put(node.left, 2 * num);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                        map.put(node.right, 2 * num + 1);
                    }
                    size--;
                    if (size == 0) {
                        end = map.get(node);
                        ans = Math.max(ans, end - start + 1);
                    }
                }
                size = list.size();
            }
            return ans;
        }
    }

}
