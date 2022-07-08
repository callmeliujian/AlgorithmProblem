package 树;
import common.TreeNode;

//给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
//
//        「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
//
//         
//
//        示例 1：
//
//
//
//        输入：root = [3,1,4,3,null,1,5]
//        输出：4
//        解释：图中蓝色节点为好节点。
//        根节点 (3) 永远是个好节点。
//        节点 4 -> (3,4) 是路径中的最大值。
//        节点 5 -> (3,4,5) 是路径中的最大值。
//        节点 3 -> (3,1,3) 是路径中的最大值。
//        示例 2：
//
//
//
//        输入：root = [3,3,null,4,2]
//        输出：3
//        解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
//        示例 3：
//
//        输入：root = [1]
//        输出：1
//        解释：根节点是好节点。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/count-good-nodes-in-binary-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
//
//        「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
//
//         
//
//        示例 1：
//
//
//
//        输入：root = [3,1,4,3,null,1,5]
//        输出：4
//        解释：图中蓝色节点为好节点。
//        根节点 (3) 永远是个好节点。
//        节点 4 -> (3,4) 是路径中的最大值。
//        节点 5 -> (3,4,5) 是路径中的最大值。
//        节点 3 -> (3,1,3) 是路径中的最大值。
//        示例 2：
//
//
//
//        输入：root = [3,3,null,4,2]
//        输出：3
//        解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
//        示例 3：
//
//        输入：root = [1]
//        输出：1
//        解释：根节点是好节点。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/count-good-nodes-in-binary-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1448_统计二叉树中好节点的数目 {
    // https://leetcode.cn/problems/count-good-nodes-in-binary-tree/solution/1448-tong-ji-er-cha-shu-zhong-hao-jie-di-iobi/
    int ans = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return ans;
    }
    private void dfs(TreeNode node, int maxValue) {
        if (node.val == maxValue) {
            ans++;
        }
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        if (leftNode != null) {
            int value = Math.max(leftNode.val, maxValue);
            dfs(leftNode, value);
        }
        if (rightNode != null) {
            int value = Math.max(rightNode.val, maxValue);
            dfs(rightNode, value);
        }
    }

}
