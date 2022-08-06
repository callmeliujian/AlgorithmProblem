package DifferenceArray_差分数组;

//假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k​​​​​​​ 个更新的操作。
//
//        其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
//
//        请你返回 k 次操作后的数组。
//
//        示例:
//
//        输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//        输出: [-2,0,3,5,3]
//        解释:
//
//        初始状态:
//        [0,0,0,0,0]
//
//        进行了操作 [1,3,2] 后的状态:
//        [0,2,2,2,0]
//
//        进行了操作 [2,4,3] 后的状态:
//        [0,2,5,5,3]
//
//        进行了操作 [0,2,-2] 后的状态:
//        [-2,0,3,5,3]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/range-addition
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _370_区间加法 {

    class Solution {
        int[] diffArray;
        public int[] getModifiedArray(int length, int[][] updates) {
            diffArray = new int[length];
            for (int i = 0; i < updates.length; i++) {
                int[] item = updates[i];
                increment(item[0], item[1], item[2]);
            }
            return result();
        }

        private void increment(int i, int j, int val) {
            diffArray[i] += val;
            if (j + 1 < diffArray.length) {
                diffArray[j+1] -= val;
            }
        }

        private int[] result() {
            int[] ans = new int[diffArray.length];
            ans[0] = diffArray[0];
            for (int i = 1; i < diffArray.length; i++) {
                ans[i] = ans[i - 1] + diffArray[i];
            }
            return ans;
        }

    }

}
