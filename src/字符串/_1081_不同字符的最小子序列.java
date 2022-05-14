package 字符串;

//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
//
//        注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
//
//         
//
//        示例 1：
//
//        输入：s = "bcabc"
//        输出："abc"
//        示例 2：
//
//        输入：s = "cbacdcbc"
//        输出："acdb"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayDeque;
import java.util.Deque;

public class _1081_不同字符的最小子序列 {

    public String smallestSubsequence(String s) {
        char[] sArray = s.toCharArray();
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        /*字符数组中的文字最后出现的位置*/
        for (int i = 0; i < sArray.length; i++) {
            lastIndex[sArray[i] - 'a'] = i;
        }
        for (int i = 0; i < sArray.length; i++) {
            if (visited[sArray[i] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > sArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top -'a'] = false;
            }
            stack.addLast(sArray[i]);
            visited[sArray[i] - 'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
