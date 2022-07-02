package 动态规划.编辑距离类型;

//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
//
//        你可以对一个单词进行如下三种操作：
//
//        插入一个字符
//        删除一个字符
//        替换一个字符
//         
//
//        示例 1：
//
//        输入：word1 = "horse", word2 = "ros"
//        输出：3
//        解释：
//        horse -> rorse (将 'h' 替换为 'r')
//        rorse -> rose (删除 'r')
//        rose -> ros (删除 'e')
//        示例 2：
//
//        输入：word1 = "intention", word2 = "execution"
//        输出：5
//        解释：
//        intention -> inention (删除 't')
//        inention -> enention (将 'i' 替换为 'e')
//        enention -> exention (将 'n' 替换为 'x')
//        exention -> exection (将 'n' 替换为 'c')
//        exection -> execution (插入 'u')
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/edit-distance
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _72_编辑距离 {
    // https://programmercarl.com/0072.编辑距离.html#_72-编辑距离
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();
        // dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
        int[][] dp = new int[word1Length + 1][word2Length + 1];
        for (int i = 0; i <= word1Length; i++) dp[i][0] = i;
        for (int j = 0; j <= word2Length; j++) dp[0][j] = j;
        for (int i = 1; i <= word1Length; i++) {
            for (int j = 1; j <= word2Length; j++) {
                if (word1CharArray[i - 1] == word2CharArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int value1 = dp[i - 1][j] + 1;
                    int value2 = dp[i][j - 1] + 1;
                    int value3 = dp[i - 1][j - 1] + 1;
                    int finalValue = Integer.MAX_VALUE;
                    finalValue = Math.min(value1,value2);
                    finalValue = Math.min(finalValue,value3);
                    dp[i][j] = finalValue;
                }
            }
        }
        return dp[word1Length][word2Length];
    }

}
