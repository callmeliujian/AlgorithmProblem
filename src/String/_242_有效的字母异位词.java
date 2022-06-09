package String;

// https://leetcode-cn.com/problems/valid-anagram/


//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//        注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//         
//
//        示例 1:
//
//        输入: s = "anagram", t = "nagaram"
//        输出: true
//        示例 2:
//
//        输入: s = "rat", t = "car"
//        输出: false

public class _242_有效的字母异位词 {

    public static boolean isAnagram1(String s, String t) {
        if (s == null || t == null) return false;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int [] charFreq = new int[26];
        if (sCharArray.length != tCharArray.length) return false;
        for (int i = 0; i < sCharArray.length; i++) {
            charFreq[sCharArray[i]-'a']++;
        }
        for (int i = 0; i < tCharArray.length; i++) {
            int temp = --charFreq[tCharArray[i]-'a'];
            if (temp < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        if (schars.length != tchars.length)
            return false;
        int [] counts = new int[26];
        for (int i = 0; i < schars.length; i++) {
            counts[schars[i] - 'a']++;
        }
        for (int i = 0; i < tchars.length; i++) {
            if (--counts[tchars[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = isAnagram1("rat", "car");
        System.out.println(ans);
    }

}
