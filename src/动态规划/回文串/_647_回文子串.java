package 动态规划.回文串;

//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
//        回文字符串 是正着读和倒过来读一样的字符串。
//
//        子字符串 是字符串中的由连续字符组成的一个序列。
//
//        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//         
//
//        示例 1：
//
//        输入：s = "abc"
//        输出：3
//        解释：三个回文子串: "a", "b", "c"
//        示例 2：
//
//        输入：s = "aaa"
//        输出：6
//        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/palindromic-substrings
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _647_回文子串 {
    //https://programmercarl.com/0647.回文子串.html#动态规划
    public int countSubstrings(String s) {
        int sLength = s.length();
        char[] sCharArray = s.toCharArray();
        // 布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        boolean[][] dp = new boolean[sLength][sLength];
        int ans = 0;
        for (int i = sLength - 1; i >= 0; i--) {
            for (int j = i; j < sLength; j++) {
                if (sCharArray[i] == sCharArray[j]) {
                    if (j - i <= 1) { // 情况一 和 情况二
                        ans++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { // 情况三
                        ans++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }

}
