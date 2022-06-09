package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _71_简化路径 {

    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String str : names) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (str.length() > 0 && !str.equals(".")) {
                stack.addLast(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()) {
            stringBuilder.append("/");
        } else {
            for (String str : stack) {
                stringBuilder.append("/");
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String args[]) {
        String str1 = "/home/";
        _71_简化路径 b = new _71_简化路径();
        String index = b.simplifyPath(str1);
        System.out.print(index);
    }

}
