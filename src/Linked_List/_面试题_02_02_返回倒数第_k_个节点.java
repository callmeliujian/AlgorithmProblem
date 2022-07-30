package Linked_List;

//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
//        注意：本题相对原题稍作改动
//
//        示例：
//
//        输入： 1->2->3->4->5 和 k = 2
//        输出： 4
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/kth-node-from-end-of-list-lcci
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _面试题_02_02_返回倒数第_k_个节点 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode p = head;
            ListNode q = head;
            for (int i = 0; i < k; i++) {
                p = p.next;
            }
            if (p == null) return head.val;
            while (p.next != null) {
                p = p.next;
                q = q.next;
            }
            return q.next.val;
        }
    }

}
