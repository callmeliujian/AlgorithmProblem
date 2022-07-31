package Linked_List;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
//        k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//         
//
//        示例 1：
//
//
//        输入：head = [1,2,3,4,5], k = 2
//        输出：[2,1,4,3,5]
//        示例 2：
//
//
//
//        输入：head = [1,2,3,4,5], k = 3
//        输出：[3,2,1,4,5]
//
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


public class _25_K_个一组翻转链表 {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode node = head;
            for (int i = 0; i < k; i++) {
                if (node == null) {
                    return head;
                } else {
                    node = node.next;
                }
            }
            ListNode newHead = reverse(head, node);
            head.next = reverseKGroup(node, k);
            return newHead;
        }


        // 翻转链表，区间为[head, node)
        private ListNode reverse(ListNode head, ListNode node) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode temp = null;
            while (cur != node) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }


    }

}
