package KMP;

//给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
//
//        如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。
//
//        字符串 s 的 前缀 是 s 的任何前导连续子字符串。
//
//         
//
//        示例 1：
//
//        输入：sentence = "i love eating burger", searchWord = "burg"
//        输出：4
//        解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
//        示例 2：
//
//        输入：sentence = "this problem is an easy problem", searchWord = "pro"
//        输出：2
//        解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
//        示例 3：
//
//        输入：sentence = "i am tired", searchWord = "you"
//        输出：-1
//        解释："you" 不是句子中任何单词的前缀。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1455_检查单词是否为句中其他单词的前缀 {

    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            char[] sentenceArray = sentence.toCharArray();
            char[] searchWordArray = searchWord.toCharArray();
            int j = 0;
            int[] next = getNext(searchWord);
            int ans = 1;
            for (int i = 0; i < sentenceArray.length; i++) {
                if (sentenceArray[i] == ' ') {
                    ans++;
                }
                while (j > 0 && sentenceArray[i] != searchWordArray[j]) {
                    j = next[j - 1];
                }
                if (sentenceArray[i] == searchWordArray[j]) {
                    j++;
                }
                if (j == searchWordArray.length) {
                    int start = i - searchWordArray.length + 1;
                    // "leetcode corona"
                    //"leetco"
                    if (start == 0) {
                        return ans;
                    }
                    // 判断单词前缀，即前一个字符是否为空格，是空格返回，不是就将 j = 0，置成初始化状态
                    if (sentenceArray[start - 1] == ' ') {
                        return ans;
                    } else {
                        j = 0;
                    }
                }
            }
            return -1;
        }

        private int[] getNext(String searchWord) {
            char[] array = searchWord.toCharArray();
            int[] next = new int[array.length];
            int j = 0;
            for (int i = 1; i < array.length; i++) {
                while (j > 0 && array[i] != array[j]) {
                    j = next[j - 1];
                }
                if (array[i] == array[j]) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }

    }


    class Solution2 {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] array = sentence.split(" ");
            for (int i = 0; i < array.length; i++) {
                if (array[i].startsWith(searchWord)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

}
