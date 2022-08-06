package DifferenceArray_差分数组;

//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
//
//        给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
//
//        当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
//
//         
//
//        示例 1：
//
//        输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//        输出：false
//        示例 2：
//
//        输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//        输出：true
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/car-pooling
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1094_拼车 {
    // https://labuladong.github.io/algo/2/20/25/
    class Solution {
        int[] diffArray;
        public boolean carPooling(int[][] trips, int capacity) {
            diffArray = new int[1001];
            for (int i = 0; i < trips.length; i++) {
                int[] item = trips[i];
                increment(item[1], item[2], item[0]);
            }
            int[] ans = result();
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] > capacity) {
                    return false;
                }
            }
            return true;
        }

        private void increment(int i, int j, int val) {
            diffArray[i] += val;
            if (j  < diffArray.length) {
                diffArray[j] -= val;
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
