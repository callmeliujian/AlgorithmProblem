package Linked_List;

// 对于一个给定的链表，返回环的入口节点，如果没有环，返回null

/**
 * 题目描述: 链表的入环节点&#xff0c;如果无环&#xff0c;返回null
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up: Can you solve it without using extra space?
 * 思路&#xff1a;
 * 1&#xff09;首先判断是否有环,有环时&#xff0c;返回相遇的节点&#xff0c;无环&#xff0c;返回null
 * 2&#xff09;有环的情况下&#xff0c; 求链表的入环节点
 *   fast再次从头出发&#xff0c;每次走一步&#xff0c;
 *   slow从相遇点出发&#xff0c;每次走一步&#xff0c;
 *   再次相遇即为环入口点。
 * 注&#xff1a;此方法在牛客BAT算法课链表的部分有讲解。
 */

public class _返回环型链表第一个头节点 {

    public  ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode meetNode = meetingNode(head);
        // 无环
        if (meetNode == null) return null;

        ListNode fast = head;
        ListNode slow = meetNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    // 是否存在环，有环返回相遇节点，无环返回null
    public ListNode meetingNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            while (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
