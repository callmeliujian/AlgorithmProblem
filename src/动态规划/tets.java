package 动态规划;

public class tets {

    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        char [] cs = s.toCharArray();
        if (cs.length == 0)
            return s;
        int maxLen = 1;
        int begin = 0;
        boolean [][] dp = new boolean[cs.length][cs.length];
        for (int i = cs.length - 1; i >= 0; i --) {
            for (int j = i; j < cs.length; j ++) {
                int len = j - i + 1;
                dp[i][j] = (cs[i] == cs[j]) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return new String(cs, begin, maxLen);
    }


}
