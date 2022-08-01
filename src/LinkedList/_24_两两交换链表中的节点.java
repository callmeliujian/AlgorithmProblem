package LinkedList;

public class _24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node1 != null && node2 != null) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
            if (node1.next != null && node2.next!= null) {
                node1 = node2.next;
                node2 = node1.next;
            } else {
                break;
            }

        }
        return head;
    }
}
