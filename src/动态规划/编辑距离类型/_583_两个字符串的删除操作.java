package 动态规划.编辑距离类型;

//给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
//
//        每步 可以删除任意一个字符串中的一个字符。
//
//         
//
//        示例 1：
//
//        输入: word1 = "sea", word2 = "eat"
//        输出: 2
//        解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
//        示例  2:
//
//        输入：word1 = "leetcode", word2 = "etco"
//        输出：4
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/delete-operation-for-two-strings
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _583_两个字符串的删除操作 {
    // dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();
        int[][] dp = new int[word1Length + 1][word2Length + 2];
        for (int i = 0; i <= word1Length; i++) dp[i][0] = i;
        for (int j = 0; j <= word2Length; j++) dp[0][j] = j;
        for (int i = 1; i <= word1Length; i++) {
            for (int j = 1; j <= word2Length; j++) {
                if (word1CharArray[i - 1] == word2CharArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int finalValue = Integer.MAX_VALUE;
                    int value1= dp[i - 1][j] + 1;
                    int value2= dp[i][j - 1] + 1;
                    int value3= dp[i - 1][j - 1] +2;
                    finalValue = Math.min(value1,value2);
                    finalValue = Math.min(finalValue,value3);
                    dp[i][j] = finalValue;
                }
            }
        }
        return dp[word1Length][word2Length];
    }

}
