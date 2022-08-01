package LinkedList;

public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归解法
    // https://labuladong.github.io/algo/2/19/19/
    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverse(head);
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode last = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }

    }

}
