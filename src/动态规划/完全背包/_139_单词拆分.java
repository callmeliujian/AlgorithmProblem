package 动态规划.完全背包;
import java.util.*;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
//        注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//
//         
//
//        示例 1：
//
//        输入: s = "leetcode", wordDict = ["leet", "code"]
//        输出: true
//        解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
//        示例 2：
//
//        输入: s = "applepenapple", wordDict = ["apple", "pen"]
//        输出: true
//        解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//             注意，你可以重复使用字典中的单词。
//        示例 3：
//
//        输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//        输出: false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/word-break
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _139_单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i <= s.length();i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j,i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
