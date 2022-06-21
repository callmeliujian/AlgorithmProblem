package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _394_字符串解码 {

    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                // 把所有的字母push进去，除了]
                stack.addFirst(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peekFirst())) {
                    // 取出[] 内的字符串
                    sb.insert(0,stack.removeFirst());
                }
                String sub = sb.toString();
                // 去除[
                stack.removeFirst();

                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peekFirst())) {
                    // 倍数
                    sb.insert(0,stack.removeFirst());
                }
                int count = Integer.valueOf(sb.toString());
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.addFirst(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0,stack.removeFirst());
        }
        return ans.toString();
    }

}
