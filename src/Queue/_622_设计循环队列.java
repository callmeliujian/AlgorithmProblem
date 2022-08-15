package Queue;

//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
//
//        循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
//
//        你的实现应该支持如下操作：
//
//        MyCircularQueue(k): 构造器，设置队列长度为 k 。
//        Front: 从队首获取元素。如果队列为空，返回 -1 。
//        Rear: 获取队尾元素。如果队列为空，返回 -1 。
//        enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
//        deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
//        isEmpty(): 检查循环队列是否为空。
//        isFull(): 检查循环队列是否已满。
//         
//
//        示例：
//
//        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//        circularQueue.enQueue(1);  // 返回 true
//        circularQueue.enQueue(2);  // 返回 true
//        circularQueue.enQueue(3);  // 返回 true
//        circularQueue.enQueue(4);  // 返回 false，队列已满
//        circularQueue.Rear();  // 返回 3
//        circularQueue.isFull();  // 返回 true
//        circularQueue.deQueue();  // 返回 true
//        circularQueue.enQueue(4);  // 返回 true
//        circularQueue.Rear();  // 返回 4
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/design-circular-queue
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _622_设计循环队列 {

    class MyCircularQueue {

        int size;
        int[] array;
        int front = 0, rear = 0;

        public MyCircularQueue(int k) {
            size = k + 1;
            array = new int[size];
            front = 0;
            rear = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            array[rear] = value;
            rear = (rear + 1) % size;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % size;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return array[front];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return array[(rear - 1 + size) % size];
        }

        public boolean isEmpty() {
            if (front == rear) return true;
            else return false;
        }

        public boolean isFull() {
            if ((rear + 1) % size == front) return true;
            else return false;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

}
