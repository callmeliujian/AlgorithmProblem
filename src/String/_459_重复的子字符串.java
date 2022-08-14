package String;

//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
//
//         
//
//        示例 1:
//
//        输入: s = "abab"
//        输出: true
//        解释: 可由子串 "ab" 重复两次构成。
//        示例 2:
//
//        输入: s = "aba"
//        输出: false
//        示例 3:
//
//        输入: s = "abcabcabcabc"
//        输出: true
//        解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/repeated-substring-pattern
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _459_重复的子字符串 {

    // https://www.programmercarl.com/0459.重复的子字符串.html#kmp
    // 使用 kmp 的next 数组
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int[] next = getNext(s);
            int length = s.length();
            if (next[length - 1] != 0 && (length % (length - next[length - 1])) == 0) {
                return true;
            }
            return false;
        }

        private int[] getNext(String s) {
            char[] sArray = s.toCharArray();
            int j = 0;
            int[] next = new int[sArray.length];
            for (int i = 1; i < sArray.length; i++) {
                while (j > 0 && sArray[i] != sArray[j]) {
                    j = next[j - 1];
                }
                if (sArray[i] == sArray[j]) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }
    }

    // https://www.programmercarl.com/0459.重复的子字符串.html#kmp
    // 通过拼接字符串的方式
    // 判断字符串s是否有重复子串组成，只要两个s拼接在一起，里面还出现一个s的话，就说明是又重复子串组成。
    //当然，我们在判断 s + s 拼接的字符串里是否出现一个s的的时候，要刨除 s + s 的首字符和尾字符，这样避免在s+s中搜索出原来的s，我们要搜索的是中间拼接出来的s。
    class Solution1 {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.length() == 0) return false;
            StringBuilder sb = new StringBuilder();
            char[] sArray = s.toCharArray();
            int length = sArray.length;
            for (int i = 0; i < 2 * length; i++) {
                sb.append(sArray[i % length]);
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
            String temp = sb.toString();
            if (temp.contains(s)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
