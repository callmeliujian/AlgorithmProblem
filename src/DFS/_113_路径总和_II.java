package DFS;
import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
//        叶子节点 是指没有子节点的节点。
//
//         
//
//        示例 1：
//
//
//        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//        输出：[[5,4,11,2],[5,8,4,5]]
//        示例 2：
//
//
//        输入：root = [1,2,3], targetSum = 5
//        输出：[]
//        示例 3：
//
//        输入：root = [1,2], targetSum = 0
//        输出：[]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/path-sum-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _113_路径总和_II {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, targetSum, new ArrayList<>(), list);
        return list;
    }

    private void dfs(TreeNode node, int remain, List<Integer> nums, List<List<Integer>> list) {
        if (node == null) return;
        remain -= node.val;
        nums.add(node.val);
        // remain == 0 不代表结束，要求到达叶子节点
        if (remain == 0 & node.left == null & node.right == null) {
            list.add(new ArrayList<>(nums));
        }
        dfs(node.left, remain, nums, list);
        dfs(node.right, remain, nums, list);
        nums.remove(nums.size() - 1);
    }

}
