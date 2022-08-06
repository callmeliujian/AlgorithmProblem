package 动态规划.回文串;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//         
//
//        示例 1：
//
//        输入：s = "babad"
//        输出："bab"
//        解释："aba" 同样是符合题意的答案。
//        示例 2：
//
//        输入：s = "cbbd"
//        输出："bb"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _5_最长回文子串 {

    // 动态规划
    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        char [] cs = s.toCharArray();
        if (cs.length == 0)
            return s;
        // 最长回文子串的长度（至少是1）
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;
        boolean [][] dp = new boolean[cs.length][cs.length];
        // 从下到上（i由大变小）
        for (int i = cs.length - 1; i >= 0; i --) {
            // 从左到右（j由小变大）
            for (int j = i; j < cs.length; j ++) {
                // cs【i，j】的长度
                int len = j - i + 1;
                dp[i][j] = (cs[i] == cs[j]) &&  (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return new String(cs, begin, maxLen);
    }

    // 双指针
    // https://labuladong.github.io/algo/2/20/23/
    class Solution {
        public String longestPalindrome(String s) {
            String ans = "";
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                String res = palindrome(s, i, i);
                String res1 = palindrome(s, i, i+1);
                ans = res.length() > ans.length() ? res : ans;
                ans = res1.length() > ans.length() ? res1 : ans;
            }
            return ans;
        }

        private String palindrome(String s, int left, int right) {
            char[] charArray = s.toCharArray();
            while (left >= 0 && right < charArray.length && charArray[left] == charArray[right]) {
                left--;
                right++;
            }
            return s.substring(left+1, right);
        }
    }

}
