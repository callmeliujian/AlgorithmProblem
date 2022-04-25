package 面试题;

public class _821_字符的最短距离 {

//    给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
//
//    返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
//
//    两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0, idx = -n; i < n; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        for (int i = n-1, idx = 2 * n; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }

}
//
//问题可以转换成，对 ss 的每个下标 ii，求
//
//        s[i]s[i] 到其左侧最近的字符 cc 的距离
//        s[i]s[i] 到其右侧最近的字符 cc 的距离
//        这两者的最小值。
//
//        对于前者，我们可以从左往右遍历 ss，若 s[i]=cs[i]=c 则记录下此时字符 cc 的的下标 \textit{idx}idx。遍历的同时更新 \textit{answer}[i]=i-\textit{idx}answer[i]=i−idx。
//
//        对于后者，我们可以从右往左遍历 ss，若 s[i]=cs[i]=c 则记录下此时字符 cc 的的下标 \textit{idx}idx。遍历的同时更新 \textit{answer}[i]=\min(\textit{answer}[i],\textit{idx}-i)answer[i]=min(answer[i],idx−i)。
//
//        代码实现时，在开始遍历的时候 \textit{idx}idx 可能不存在，为了简化逻辑，我们可以用 -n−n 或 2n2n 表示，这里 nn 是 ss 的长度。
//
//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character/solution/zi-fu-de-zui-duan-ju-chi-by-leetcode-sol-2t49/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
