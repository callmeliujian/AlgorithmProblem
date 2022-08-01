package LinkedList;

public class _19_删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummyHead;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

}
