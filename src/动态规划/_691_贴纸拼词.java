package 动态规划;

//我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
//
//        您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
//
//        返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
//
//        注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
//
//         
//
//        示例 1：
//
//        输入： stickers = ["with","example","science"], target = "thehat"
//        输出：3
//        解释：
//        我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
//        把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
//        此外，这是形成目标字符串所需的最小贴纸数量。
//        示例 2:
//
//        输入：stickers = ["notice","possible"], target = "basicbasic"
//        输出：-1
//        解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/stickers-to-spell-word
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashMap;

public class _691_贴纸拼词 {

    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] map = new int[n][26];
        HashMap<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c - 'a']++;
            }
        }
        dp.put("",0);
        return process1(dp,map,target);
    }
    // dp 傻缓存，如果 rest 已经计算过了，直接返回 dp 中的值
    // t 剩余目标
    // 0...N 每一个字符串所含字符的词频统计
    // 返回值是 -1， map 中的贴纸怎么都无法 rest
    private int process1(HashMap<String, Integer>dp, int[][] map, String rest) {
        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }
        // 已下就是正式的递归调用过程
        int ans = Integer.MAX_VALUE; // ans-> 搞定 rest，使用的最少的贴纸数量
        int n = map.length; // N种贴纸
        int[] rest_map = new int[26]; // rest_map 去替代 rest
        char[] target = rest.toCharArray();
        for (char c : target) {
            rest_map[c - 'a']++;
        }
        // map -> rest_map
        for (int i = 0; i < n; i ++) {
//            if (map[i][target[0] - 'a'] == 0 ) {
//                continue;
//            }
            StringBuilder sb = new StringBuilder();
            // i 贴纸，j 枚举 a～z字符
            for (int j = 0; j < 26; j++) {
                if (rest_map[j] > 0) {
                    for (int k = 0; k < Math.max(0, rest_map[j] - map[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            String s = sb.toString();
            int tmp = process1(dp,map,s);
            if (tmp != -1) {
                ans = Math.min(ans, (1 + tmp));
            }
        }
        dp.put(rest, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(rest);
    }

    public static void main(String[] args) {
        _691_贴纸拼词 a = new _691_贴纸拼词();
        String[] strArray = {"with","example","science"};
        String traget = "thehat";
        int value = a.minStickers(strArray,traget);
        System.out.println(value);
    }

}
