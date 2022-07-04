package 动态规划.编辑距离类型;

//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//
//        字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//
//        题目数据保证答案符合 32 位带符号整数范围。
//
//         
//
//        示例 1：
//
//        输入：s = "rabbbit", t = "rabbit"
//        输出：3
//        解释：
//        如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//        rabbbit
//        rabbbit
//        rabbbit
//        示例 2：
//
//        输入：s = "babgbag", t = "bag"
//        输出：5
//        解释：
//        如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
//        babgbag
//        babgbag
//        babgbag
//        babgbag
//        babgbag
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/distinct-subsequences
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _115_不同的子序列 {
    // https://programmercarl.com/0115.不同的子序列.html#其他语言版本
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tlength = t.length();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        // dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
        int[][] dp = new int[sLength+1][tlength+1];
        // 初始化
        for (int i = 0; i <= sLength; i++) dp[i][0] = 1;
        for (int j = 0; j <= tlength; j++) dp[0][j] = 0;
        dp[0][0] = 1;
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= tlength; j++) {
                if (sCharArray[i-1] == tCharArray[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sLength][tlength];
    }

}
