package String;

//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
//        示例 1：
//
//        输入: s1 = "abc", s2 = "bca"
//        输出: true
//        示例 2：
//
//        输入: s1 = "abc", s2 = "bad"
//        输出: false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/check-permutation-lcci
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _面试题_01_02_判定是否互为字符重排 {
    // https://leetcode.cn/problems/check-permutation-lcci/solution/pan-ding-shi-fou-hu-wei-zi-fu-zhong-pai-dmkmc/
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            char[] s1CharArray = s1.toCharArray();
            char[] s2CharArray = s2.toCharArray();
            int[] num = new int[26];
            for (char item : s1CharArray) {
                num[item - 'a']++;
            }
            for (char item : s2CharArray) {
                int index = item - 'a';
                num[index]--;
                if (num[index] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
