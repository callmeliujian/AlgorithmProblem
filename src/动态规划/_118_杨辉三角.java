package 动态规划;
import java.util.*;

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//        示例 1:
//
//        输入: numRows = 5
//        输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//        示例 2:
//
//        输入: numRows = 1
//        输出: [[1]]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/pascals-triangle
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _118_杨辉三角 {
    // https://leetcode.cn/problems/pascals-triangle/solution/yang-hui-san-jiao-by-leetcode-solution-lew9/

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    item.add(1);
                } else {
                    item.add(ans.get(i - 1).get(j-1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(item);
        }
        return ans;
    }

}
