package LinkedList;

public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyHead = new ListNode();
        ListNode lastNode = dummyHead;
        // 进位值
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            // 设置进位
            carry = sum / 10;
            // sum的个位数字作为新节点的值
            lastNode.next = new ListNode(sum % 10);
            lastNode = lastNode.next;
        }
        // 最后检查进位
        if (carry != 0) {
            lastNode.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
