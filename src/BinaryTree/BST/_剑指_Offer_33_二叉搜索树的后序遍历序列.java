package BinaryTree.BST;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//         
//
//        参考以下这颗二叉搜索树：
//
//        5
//        / \
//        2   6
//        / \
//        1   3
//        示例 1：
//
//        输入: [1,6,3,2,5]
//        输出: false
//        示例 2：
//
//        输入: [1,3,2,6,5]
//        输出: true
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _剑指_Offer_33_二叉搜索树的后序遍历序列 {
    // https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
    // 遍历后序遍历的 [i, j][i,j] 区间元素，寻找 第一个大于根节点 的节点，索引记为 mm 。此时，可划分出左子树区间 [i,m-1][i,m−1] 、右子树区间 [m, j - 1][m,j−1] 、根节点索引 jj 。
    //时间复杂度 O(N^2)   空间复杂度 O(N)
    //class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0 , postorder.length - 1);
        }
        // i, j 为遍历 postorder 的范围，如果i == j 说明遍历到了子节点，只有一个元素
        private boolean recur(int[] postorder, int i, int j) {
            // 为什么 i >= j, 数组为 {1,2,5,10,6,9,4,3}的时候，遍历到{1,2}的时候，i = 0，j,p,m 都为1，当进行到 recur(postorder, m, j - 1)
            // 的时候 m > j - 1,如果不判断大于则数组越界，在 while (postorder[p] > postorder[j]) 的时候
            // 判断  if (i > j) i = j 只存在一个节点
            // 通过区间定义可知 i 不能大于 j
            if (i == j) return true;
            int p = i;
            while (postorder[p] < postorder[j]) p++;
            int m = p;
            while (postorder[p] > postorder[j])
                p++;
            return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
        //}

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,5,10,6,9,4,3};
        _剑指_Offer_33_二叉搜索树的后序遍历序列 s = new _剑指_Offer_33_二叉搜索树的后序遍历序列();
        boolean ans = s.verifyPostorder(array);
        System.out.println(ans);
    }

}
