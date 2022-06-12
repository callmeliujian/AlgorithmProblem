package 栈_队列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        int ans = 0;
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                ans = stackIn.pop();
                stackOut.push(ans);
            }
            ans = stackOut.pop();
            while (!stackOut.isEmpty()) {
                int temp = stackOut.pop();
                stackIn.push(temp);
            }
        } else {
            ans = stackOut.pop();
        }

        return ans;
    }

    public int peek() {
        int ans = pop();
        stackOut.push(ans);
        return ans;
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
