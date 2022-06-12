package 栈_队列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class _1047_删除字符串中的所有相邻重复项 {

    public String removeDuplicates(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] sCharArray = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : sCharArray) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                char temp = stack.peek();
                if (temp == c) {
                    stack.remove();
                } else {
                    stack.addFirst(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        _1047_删除字符串中的所有相邻重复项 a = new _1047_删除字符串中的所有相邻重复项();
        String ans = a.removeDuplicates(s);
        System.out.println(ans);
    }

}
