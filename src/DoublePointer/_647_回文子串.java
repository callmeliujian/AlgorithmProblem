package DoublePointer;

//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
//        回文字符串 是正着读和倒过来读一样的字符串。
//
//        子字符串 是字符串中的由连续字符组成的一个序列。
//
//        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//         
//
//        示例 1：
//
//        输入：s = "abc"
//        输出：3
//        解释：三个回文子串: "a", "b", "c"
//        示例 2：
//
//        输入：s = "aaa"
//        输出：6
//        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/palindromic-substrings
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _647_回文子串 {
    // https://programmercarl.com/0647.回文子串.html#双指针法
    public int countSubstrings(String s) {
        int ans = 0;
        char[] sCharArray = s.toCharArray();
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            ans += extend(sCharArray,i,i,sLength);
            ans += extend(sCharArray,i,i+1,sLength);
        }
        return ans;
    }

    private int extend(char[] sCharArray, int i ,int j, int size) {
        int ans = 0;
        while (i >= 0 && j < size && sCharArray[i] == sCharArray[j]) {
            ans++;
            i--;
            j++;
        }
        return ans;
    }

}
