package 栈;

import 字符串._402_移掉K位数字;

import java.util.ArrayDeque;
import java.util.Deque;

public class _32_最长有效括号 {

    public int longestValidParentheses(String s) {
        int res = 0;
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if (currentChar == '(') {
                stack.addLast(currentChar);
            } else {
                char stackChar = stack.peekLast();
                if (stackChar == '(' && !stack.isEmpty()) {
                    stack.removeLast();
                    res+=2;
                } else  {
                    stack.addLast(currentChar);
                }
            }
        }
        if (stack.peekLast() == '(' && res != 2) {
            res-=2;
        }
        return res;
    }

    public static void main(String args[]) {
        String str1 = "()(()";
        _32_最长有效括号 b = new _32_最长有效括号();
        int index = b.longestValidParentheses(str1);
        System.out.print(index);
    }

}
