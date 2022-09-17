package Array;
import java.util.*;

//给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
//
//        子字符串 是字符串中的一个连续字符序列。
//
//         
//
//        示例 1：
//
//        输入：s = "aa"
//        输出：0
//        解释：最优的子字符串是两个 'a' 之间的空子字符串。
//        示例 2：
//
//        输入：s = "abca"
//        输出：2
//        解释：最优的子字符串是 "bc" 。
//        示例 3：
//
//        输入：s = "cbzxy"
//        输出：-1
//        解释：s 中不存在出现出现两次的字符，所以返回 -1 。
//        示例 4：
//
//        输入：s = "cabbac"
//        输出：4
//        解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/largest-substring-between-two-equal-characters
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1624_两个相同字符之间的最长子字符串 {
    // https://leetcode.cn/problems/largest-substring-between-two-equal-characters/solution/liang-ge-xiang-tong-zi-fu-zhi-jian-de-zu-9n2l/
    // 时间：o(N)
    // 空间：O(∣Σ∣) ∣Σ∣=26
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int[] charArray = new int[26];
            char[] sArray = s.toCharArray();
            Arrays.fill(charArray, -1);
            int ans = -1;
            for (int i = 0; i < sArray.length; i++) {
                int index = sArray[i] - 'a';
                if (charArray[index] < 0) {
                    charArray[index] = i;
                } else {
                    ans = Math.max(ans, i - charArray[index] - 1);
                }
            }
            return ans;
        }
    }

}
