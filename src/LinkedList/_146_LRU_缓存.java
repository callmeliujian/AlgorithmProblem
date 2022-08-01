package LinkedList;
import java.util.*;

//请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
//        实现 LRUCache 类：
//        LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
//        int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//        void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//        函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//         
//
//        示例：
//
//        输入
//        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//        输出
//        [null, null, null, 1, null, -1, null, -1, 3, 4]
//
//        解释
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.get(1);    // 返回 -1 (未找到)
//        lRUCache.get(3);    // 返回 3
//        lRUCache.get(4);    // 返回 4
//         
//
//        提示：
//
//        1 <= capacity <= 3000
//        0 <= key <= 10000
//        0 <= value <= 105
//        最多调用 2 * 105 次 get 和 put
//
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/lru-cache
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _146_LRU_缓存 {

}

class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    // 虚拟头节点
    private Node firstNode;
    // 虚拟尾节点
    private Node lastNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        firstNode = new Node();
        lastNode = new Node();
        firstNode.next = lastNode;
        lastNode.pre = firstNode;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        removeNode(node);
        addAfterFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addAfterFirst(node);
        } else {
            int size = map.size();
            if (size == capacity) {
                removeNode(map.remove(lastNode.pre.key));
            }
            Node newNode = new Node(key,value);
            addAfterFirst(newNode);
            map.put(key,newNode);
        }
    }

    private void removeNode(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    private void addAfterFirst(Node node) {
        Node nextNode = firstNode.next;
        // firstNode 与 node 关系
        firstNode.next = node;
        node.pre = firstNode;
        // node 与 nextNode 关系
        node.next = nextNode;
        nextNode.pre = node;
    }

    private static class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
        public Node(){}
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
