package 动态规划.编辑距离类型;

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//        进阶：
//
//        如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
//
//        致谢：
//
//        特别感谢 @pbrother 添加此问题并且创建所有测试用例。
//
//         
//
//        示例 1：
//
//        输入：s = "abc", t = "ahbgdc"
//        输出：true
//        示例 2：
//
//        输入：s = "axc", t = "ahbgdc"
//        输出：false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/is-subsequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _392_判断子序列 {
    // https://programmercarl.com/0392.判断子序列.html#思路
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        // dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
        int[][] dp = new int[sLength + 1][tLength + 1];
        // 遍历顺序。从上到下，从左到右。或者从左到右从下到上都行
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= tLength; j++) {
            //在确定递推公式的时候，首先要考虑如下两种操作，整理如下：
            // if (s[i - 1] == t[j - 1])
            // t中找到了一个字符在s中也出现了
            // if (s[i - 1] != t[j - 1])
            // 相当于t要删除元素，继续匹配
            // if (s[i - 1] == t[j - 1])，那么dp[i][j] = dp[i - 1][j - 1] + 1;，因为找到了一个相同的字符，相同子序列长度自然要在dp[i-1][j-1]的基础上加1（如果不理解，在回看一下dp[i][j]的定义）
            // if (s[i - 1] != t[j - 1])，此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，那么dp[i][j] 的数值就是 看s[i - 1]与 t[j - 2]的比较结果了，即：dp[i][j] = dp[i][j - 1];
                if (sCharArray[i-1] == tCharArray[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if (dp[sLength][tLength] == s.length()) {
            return true;
        } else {
            return false;
        }
    }

}
