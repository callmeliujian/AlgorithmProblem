package DoublePointer;

//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
//
//        数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
//
//         
//
//        示例 1：
//
//        输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//        输出：true
//        解释：
//        word1 表示的字符串为 "ab" + "c" -> "abc"
//        word2 表示的字符串为 "a" + "bc" -> "abc"
//        两个字符串相同，返回 true
//        示例 2：
//
//        输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//        输出：false
//        示例 3：
//
//        输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//        输出：true
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1662_检查两个字符串数组是否相等 {

    // https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/solution/by-ac_oier-h0l6/
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int m = word1.length, n = word2.length;
            // i,j 代表遍历到数组 word1、word2 哪个位置，p,q 代表遍历 word1[i],word2[j] 哪个位置
            int i = 0, j = 0, p = 0, q = 0;
            while (i < m && j < n) {
                if (word1[i].charAt(p++) != word2[j].charAt(q++)) {
                    return false;
                }
                if (p == word1[i].length()) {
                    i++;
                    p = 0;
                }
                if (q == word2[j].length()) {
                    j++;
                    q = 0;
                }
            }
            return i == m && j == n;
        }
    }

    class Solution1 {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            String str1 = "", str2 = "";
            for (String str : word1) {
                str1 = str1 + str;
            }
            for (String str : word2) {
                str2 = str2 + str;
            }
            if (str1.equals(str2)) {
                return true;
            } else {
                return false;
            }
        }
    }

}
