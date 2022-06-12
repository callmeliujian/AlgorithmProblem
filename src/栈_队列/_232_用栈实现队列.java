package 栈_队列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class _232_用栈实现队列 {

}

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int ans = 0;
        while (!stack1.isEmpty()) {
            ans = stack1.pop();
            stack2.push(ans);
        }
        ans = stack2.pop();
        while (!stack2.isEmpty()) {
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return ans;
    }

    public int peek() {
        int ans = 0;
        while (!stack1.isEmpty()) {
            ans = stack1.pop();
            stack2.push(ans);
        }
        ans = stack2.peek();
        while (!stack2.isEmpty()) {
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return ans;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
