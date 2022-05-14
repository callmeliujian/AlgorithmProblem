package 字符串;

//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
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
//        链接：https://leetcode-cn.com/problems/remove-duplicate-letters
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// 字典序：字母按照字典里面的顺序展示

import java.util.ArrayDeque;
import java.util.Deque;

public class _316_去除重复字母 {

    public String removeDuplicateLetters(String s) {
        char[] sArray = s.toCharArray();
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < sArray.length; i++) {
            lastIndex[sArray[i] - 'a'] = i;
        }
        for (int i = 0; i < sArray.length; i++) {
            // 为了保证字典序，如果前面存在了 再来一个就 pass
            if (visited[sArray[i] - 'a']) {
                continue;
            }
            // 把栈里面能弹出元素全部弹出
            while (!stack.isEmpty() && stack.peekLast() > sArray[i] &&lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
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
