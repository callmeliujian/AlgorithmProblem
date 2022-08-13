package KMP;

//实现 strStr() 函数。
//
//        给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
//
//        说明：
//
//        当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
//        对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
//
//         
//
//        示例 1：
//
//        输入：haystack = "hello", needle = "ll"
//        输出：2
//        示例 2：
//
//        输入：haystack = "aaaaa", needle = "bba"
//        输出：-1
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/implement-strstr
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _28_实现_strStr {
    // https://www.programmercarl.com/0028.实现strStr.html#其他语言版本
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.length() == 0) return 0;

            int[] next = getNext(needle);
            int j = 0;
            char[] haystackArray = haystack.toCharArray();
            char[] needleArray = needle.toCharArray();
            for (int i = 0; i < haystackArray.length; i++) {
                while (j > 0 && haystackArray[i] != needleArray[j]) {
                    j = next[j - 1];
                }
                if (haystackArray[i] == needleArray[j]) {
                    j++;
                }
                if (j == needleArray.length) {
                    return (i - needleArray.length + 1);
                }
            }

            return -1;
        }

        private int[] getNext(String needle) {
            char[] needleArray = needle.toCharArray();
            int[] next = new int[needleArray.length];
            int j = 0;
            for (int i = 1; i < needleArray.length; i++) {
                while (j > 0 && needleArray[j] != needleArray[i]) {
                    j = next[j - 1];
                }
                if (needleArray[i] == needleArray[j]) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }

    }

}
