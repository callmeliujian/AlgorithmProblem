package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _20_有效的括号 {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i ++) {
            char currentChar = array[i];
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.addLast(currentChar);
            } else {
                if (stack.size() > 0) {
                    char stackChar = stack.peekLast();
                    if ((stackChar == '(' && currentChar == ')') || (stackChar == '[' && currentChar == ']')  || (stackChar == '{' && currentChar == '}') ) {
                        stack.removeLast();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }

    }
}
