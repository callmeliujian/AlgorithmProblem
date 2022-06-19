package Sort;

import java.util.*;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//         
//
//        示例 1：
//
//        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出：[[1,6],[8,10],[15,18]]
//        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//        示例 2：
//
//        输入：intervals = [[1,4],[4,5]]
//        输出：[[1,5]]
//        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/merge-intervals
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _56_合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < left) {
                ans.add(new int[]{left,right});
            } else {
                // [[1,4],[2,3]]
                ans.get(ans.size() -  1)[1] = Math.max(ans.get(ans.size() - 1)[1],right);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
