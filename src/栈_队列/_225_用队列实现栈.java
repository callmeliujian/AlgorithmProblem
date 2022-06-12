package 栈_队列;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        int ans = 0;
        while (!queue1.isEmpty()) {
            ans = queue1.poll();
            if (!queue1.isEmpty()) {
                queue2.add(ans);
            }
        }
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return ans;
    }

    public int top() {
        int ans = 0;
        while (!queue1.isEmpty()) {
            ans = queue1.poll();
            queue2.add(ans);
        }
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return ans;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
