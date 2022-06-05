package HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//        字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
//
//         
//
//        示例 1:
//
//        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//        示例 2:
//
//        输入: strs = [""]
//        输出: [[""]]
//        示例 3:
//
//        输入: strs = ["a"]
//        输出: [["a"]]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/group-anagrams
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _49_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();
        HashMap<String,List> ans = new HashMap<>();
        for (String s : strs) {
            int[] charFreq = new int[26];
            for (char c : s.toCharArray()) ++charFreq[c - 'a'];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(charFreq[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key,new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
