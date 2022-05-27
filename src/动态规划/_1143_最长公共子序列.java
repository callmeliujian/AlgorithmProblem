package 动态规划;

public class _1143_最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        return lcse(str1,str2);
    }

    // 两个字符数组 str1[0...i] 和 str2[0...j]
    // 1. 最长公共子序列可能既不已 str1[i] 也不已 str2[j] 结尾 例如 ab123c d123ef 其最长公共子序列为 123 -> dp[i - 1][j - 1]
    // 2. 最长公共子序列可能以 str1[i] 结尾，不以 str2[j] 结尾 例如 ab123 c123ef 其最长公共子序列为 123 -> dp[i][j - 1]
    // 3. 最长公共子序列不以 str1[i] 结尾，可能以 str2[j] 结尾 例如 ab123c cf123 其最长公共子序列为 123 -> dp[i - 1][j]
    // 4. 最长公共子序列即可能以 str1[i] 结尾，又可能以 str2[j] 结尾 例如 ab12c3 d12ef3 存在条件为 str1[i] == str2[j] 其最长公共子序列为 123 -> dp[i - 1][j - 1] + 1
    private int lcse(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1:0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[str1.length - 1][str2.length - 1];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        _1143_最长公共子序列 a = new _1143_最长公共子序列();
        int value = a.longestCommonSubsequence(str1,str2);
        System.out.println(value);
    }

}
