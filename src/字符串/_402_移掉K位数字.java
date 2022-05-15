package 字符串;

import 算法.BruteForce;

import java.util.ArrayDeque;
import java.util.Deque;

//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
//        示例 1 ：
//
//        输入：num = "1432219", k = 3
//        输出："1219"
//        解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
//        示例 2 ：
//
//        输入：num = "10200", k = 1
//        输出："200"
//        解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//        示例 3 ：
//
//        输入：num = "10", k = 2
//        输出："0"
//        解释：从原数字移除所有的数字，剩余为空就是 0 。
//         
//
//        提示：
//
//        1 <= k <= num.length <= 105
//        num 仅由若干位数字（0 - 9）组成
//        除了 0 本身之外，num 不含任何前导零
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/remove-k-digits
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _402_移掉K位数字 {

    public String removeKdigits(String num, int k) {
        char[] numArray = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < numArray.length; i++) {
            char currentChar = numArray[i];
            while (!stack.isEmpty() && k > 0 && (stack.peekLast() - '0' > currentChar - '0')) {
                stack.pollLast();
                k--;
            }
            stack.addLast(currentChar);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean leftZero = true;
        for (char c : stack) {
            if (leftZero && c == '0') {
                continue;
            }
            leftZero = false;
            stringBuilder.append(c);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public String removeKdigits1(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    public static void main(String args[]) {
        String str1 = "120";
        int str2 = 2;
        _402_移掉K位数字 b = new _402_移掉K位数字();
        String index = b.removeKdigits(str1,str2);
        System.out.print(index);
    }


}
