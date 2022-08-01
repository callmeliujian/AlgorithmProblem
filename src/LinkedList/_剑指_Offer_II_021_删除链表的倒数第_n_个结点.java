package LinkedList;

//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//         
//
//        示例 1：
//
//
//
//        输入：head = [1,2,3,4,5], n = 2
//        输出：[1,2,3,5]
//        示例 2：
//
//        输入：head = [1], n = 1
//        输出：[]
//        示例 3：
//
//        输入：head = [1,2], n = 1
//        输出：[1]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/SLwz0R
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _剑指_Offer_II_021_删除链表的倒数第_n_个结点 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode p = head;
            ListNode q = head;
            for (int i = 0; i < n; i++) {
                p = p.next;
            }
            if (p == null) {
                return head.next;
            }
            while (p.next != null) {
                p = p.next;
                q = q.next;
            }
            q.next = q.next.next;
            return head;
        }
    }

}
