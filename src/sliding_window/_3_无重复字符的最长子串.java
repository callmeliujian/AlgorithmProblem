package sliding_window;

import java.util.HashMap;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//提示：
//
//        0 <= s.length <= 5 * 104
//s 由英文字母、数字、符号和空格组成

public class _3_无重复字符的最长子串 {

    // https://labuladong.github.io/algo/2/20/27/

    class Solution_1 {
        public int lengthOfLongestSubstring(String s) {
            char[] sArray = s.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            int length = sArray.length;
            int left = 0;
            int right = 0;
            int ans = 0;
            for (int i = 0; i < length; i++) {
                char rightItem = sArray[right];
                if (map.containsKey(rightItem)) {
                    // 如果写成 left = map.get(rightItem) + 1 测试用例:"abba" 执行不正确
                    // + 1 是取当前重复字符串的下一位，因为已经重复了，当前的需要被舍弃。例如，测试用例:"abcabcbb"，读取到第二个a的时候，字符串应该为 "bca", 如果不加一就是 “abca”
                    left = Math.max(left, map.get(rightItem) + 1);
                }
                map.put(rightItem, i);
                ans = Math.max(ans, right - left + 1);
                right++;
            }
            return ans;
        }
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] sArray = s.toCharArray();
            int ans = 0;
            HashMap<Character, Integer> windowMap = new HashMap<>();
            int left = 0, right = 0;
            while (right < sArray.length) {
                char rightItem = sArray[right];
                right++;
                windowMap.put(rightItem, windowMap.getOrDefault(rightItem, 0) + 1);
                while (windowMap.get(rightItem) > 1) {
                    char leftItem = sArray[left];
                    left++;
                    windowMap.put(leftItem, windowMap.get(leftItem)-1);
                }
                ans = Math.max(ans, right - left);
            }
            return ans;
        }
    }


    public int lengthOfLongestSubstring(String s) {
        int max_len = 0;
        char[] charArray = s.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int start = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.containsKey(charArray[i])) {
                hashMap.put(charArray[i],hashMap.get(charArray[i]) + 1);
            } else {
                hashMap.put(charArray[i], 1);
            }
            if (hashMap.size() == i - start + 1) {
                max_len = Math.max(max_len, i - start + 1);
            }
            while (i - start + 1 > hashMap.size()) {
                char head = charArray[start];
                int value = hashMap.get(head) - 1;
                if (value == 0) {
                    hashMap.remove(head);
                } else {
                    hashMap.put(head,value);
                }
                start++;
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串 ob = new _3_无重复字符的最长子串();
        String str = "eeydgwdykpv";
        int length = ob.lengthOfLongestSubstring(str);
        System.out.println(length);
    }

}
