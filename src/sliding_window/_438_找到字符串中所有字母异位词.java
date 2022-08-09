package sliding_window;

// https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
//        异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
//
//         
//
//        示例 1:
//
//        输入: s = "cbaebabacd", p = "abc"
//        输出: [0,6]
//        解释:
//        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//         示例 2:
//
//        输入: s = "abab", p = "ab"
//        输出: [0,1,2]
//        解释:
//        起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//        起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//        起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//         
//
//        提示:
//
//        1 <= s.length, p.length <= 3 * 104
//        s 和 p 仅包含小写字母

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _438_找到字符串中所有字母异位词 {
    // https://labuladong.github.io/algo/2/20/27/
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            HashMap<Character, Integer> needMap = new HashMap<>();
            HashMap<Character, Integer> windowMap = new HashMap<>();
            char[] pArray = p.toCharArray();
            char[] sArray = s.toCharArray();
            for (char item : pArray) {
                needMap.put(item, needMap.getOrDefault(item, 0) + 1);
            }

            int left = 0, right = 0, vaild = 0;
            while (right < sArray.length) {
                char rightItem = sArray[right];
                right++;
                if (needMap.containsKey(rightItem)) {
                    windowMap.put(rightItem, windowMap.getOrDefault(rightItem, 0) + 1);
                    if (windowMap.get(rightItem).equals(needMap.get(rightItem))) {
                        vaild++;
                    }
                }

                while (vaild == needMap.size()) {
                    if ((right - left) == pArray.length) {
                        ans.add(left);
                    }
                    char leftItem = sArray[left];
                    left++;
                    if (needMap.containsKey(leftItem)) {
                        int needMapValue = needMap.get(leftItem);
                        int windowMapValue = windowMap.get(leftItem);
                        if (windowMapValue == needMapValue) {
                            vaild--;
                        }
                        windowMap.put(leftItem, windowMapValue - 1);
                    }
                }

            }
            return ans;
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        HashMap<Character,Integer> hashMap_p = new HashMap<>();
        char[] pCharArray = p.toCharArray();
        char[] sCharArray = s.toCharArray();
        // 将 string p 放入 hashmap
        for (int i = 0; i < pCharArray.length; i++) {
            char c = pCharArray[i];
            int value = hashMap_p.getOrDefault(c,0) + 1;
            hashMap_p.put(c,value);
        }
        int start = 0;
        for (int i = 0; i < sCharArray.length; i++) {
            char c = sCharArray[i];
            int value = hashMap.getOrDefault(c,0) + 1;
            hashMap.put(c,value);
            if (hashMap.equals(hashMap_p)) {
                res.add(start);
            }
            if (i >= pCharArray.length - 1) {
                char head = sCharArray[start];
                int headValue = hashMap.get(head) - 1;
                if (headValue == 0) {
                    hashMap.remove(head);
                } else {
                    hashMap.put(head,headValue);
                }
                start++;
            }
        }

        return res;
    }

    public static  void main(String[] args) {
        _438_找到字符串中所有字母异位词 ob = new _438_找到字符串中所有字母异位词();
        String s = "abacd";
        String p = "abc";
        List<Integer> res = ob.findAnagrams(s,p);
        System.out.println(res);
    }

}
