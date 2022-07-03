package 动态规划.回文串;

//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//
//        子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
//        示例 1：
//
//        输入：s = "bbbab"
//        输出：4
//        解释：一个可能的最长回文子序列为 "bbbb" 。
//        示例 2：
//
//        输入：s = "cbbd"
//        输出：2
//        解释：一个可能的最长回文子序列为 "bb" 。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/longest-palindromic-subsequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _516_最长回文子序列 {
    // https://programmercarl.com/0516.最长回文子序列.html#思路
    public int longestPalindromeSubseq(String s) {
        int sLength = s.length();
        char[] sCharArray = s.toCharArray();
        // dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
        int[][] dp = new int[sLength][sLength];
        for (int i = 0; i < sLength; i++) {
            dp[i][i] = 1;
        }
        for (int i = sLength - 1; i >=0; i--) {
            for (int j = i+1; j < sLength; j++) {
                if (sCharArray[i] == sCharArray[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][sLength-1];
    }

}
