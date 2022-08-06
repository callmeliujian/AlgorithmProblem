package BF;
import java.util.*;

//给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
//
//        如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
//
//         
//
//        示例 1：
//
//        输入：words = ["mass","as","hero","superhero"]
//        输出：["as","hero"]
//        解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
//        ["hero","as"] 也是有效的答案。
//        示例 2：
//
//        输入：words = ["leetcode","et","code"]
//        输出：["et","code"]
//        解释："et" 和 "code" 都是 "leetcode" 的子字符串。
//        示例 3：
//
//        输入：words = ["blue","green","bu"]
//        输出：[]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/string-matching-in-an-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1408_数组中的字符串匹配 {

    // 我们先把words中所有的单词拼成一个大的字符串，然后判断每个字符串是不是有两个位置，有两个位置则证明是存在某个单词是子字符串，加入答案
    // https://leetcode.cn/problems/string-matching-in-an-array/solution/shu-zi-hui-zong-de-zi-fu-pi-pei-by-capit-akzf/
    class Solution1 {
        public List<String> stringMatching(String[] words) {
            List<String> ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (String item : words) {
                // 需要加上分隔符，避免两个字符串拼接成新新字符串符合字串的判定规则
                // 输入：["uexk","aeuexkf","wgxih","yuexk","gxea","yuexkm","ypmfx","jjuexkmb","wqpri","aeuexkfpo","kqtnz","pkqtnza","nrbb","hmypmfx","krqs","jjuexkmbyt","zvru","ypmfxj"]
                // 输出：["uexk","aeuexkf","yuexk","ypmfx","jjuexkmb","kqtnz","ypmfxj"]
              //预期结果：["uexk","aeuexkf","yuexk","ypmfx","jjuexkmb","kqtnz"]
                sb.append(item).append(",");
            }
            for (String item : words) {
                if (sb.indexOf(item) != sb.lastIndexOf(item)) {
                    ans.add(item);
                }
            }
            return ans;
        }
    }
    // https://leetcode.cn/problems/string-matching-in-an-array/solution/by-ac_oier-k03v/
    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> ans = new ArrayList<>();
            int length  = words.length;
            for (int i = 0; i < length; i ++) {
                for (int j = 0; j < length; j++) {
                    if (i == j) continue;
                    if (words[j].indexOf(words[i]) >= 0) {
                        ans.add(words[i]);
                        break;
                    }
                }
            }
            return ans;
        }
    }

}
