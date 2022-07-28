package Heap;
import java.util.PriorityQueue;

public class demo {

    public static void main(String[] args) {
        demo.f3();
    }
    // 下列所有优先队列初始化大小都是 11。
    //小根堆
    private static void f1() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(5);
        queue.offer(1);
        queue.offer(20);
        queue.offer(25);
        queue.offer(6);
        queue.offer(11);
        queue.offer(23);
        while (!queue.isEmpty()) {
            System.out.println( queue.poll());
        }
    }

    //小根堆
    private static void f2() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->a - b);
        queue.offer(5);
        queue.offer(1);
        queue.offer(20);
        queue.offer(25);
        queue.offer(6);
        queue.offer(11);
        queue.offer(23);
        while (!queue.isEmpty()) {
            System.out.println( queue.poll());
        }
    }

    //大根堆
    private static void f3() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b - a);
        queue.offer(5);
        queue.offer(1);
        queue.offer(20);
        queue.offer(25);
        queue.offer(6);
        queue.offer(11);
        queue.offer(23);
        while (!queue.isEmpty()) {
            System.out.println( queue.poll());
        }
    }

}
