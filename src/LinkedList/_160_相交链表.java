package LinkedList;
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。

public class _160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA :curB.next;
        }
        return curA;
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA, q = headB;
            while (p != q) {
                if (p == null) {
                    p = headB;
                } else {
                    p = p.next;
                }
                if (q == null) {
                    q = headA;
                } else {
                    q = q.next;
                }
            }
            return p;
        }
    }


}
